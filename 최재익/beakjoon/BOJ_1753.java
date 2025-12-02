import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }

    static List<List<Node>> graph;
    static int V,E,K;
    static int[] distance;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i=0; i<=V; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        distance = new int[V+1];
        Arrays.fill(distance, INF);
        distance[K] = 0;

        dijkstra();
        for(int i=1; i<distance.length; i++){
            if(distance[i]==INF){
                System.out.println("INF");
                continue;
            }
            System.out.println(distance[i]);
        }
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(cur.weight>distance[cur.vertex])continue;

            for(int i=0; i<graph.get(cur.vertex).size(); i++){
                Node next = graph.get(cur.vertex).get(i);

                if(distance[next.vertex]>distance[cur.vertex]+next.weight){
                    distance[next.vertex] = distance[cur.vertex] + next.weight;
                    pq.add(new Node(next.vertex, distance[next.vertex]));
                }
            }
        }
    }
}
