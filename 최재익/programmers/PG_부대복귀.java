import java.util.*;

class PG_부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] map = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            map[road[0]].add(road[1]);
            map[road[1]].add(road[0]);
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);
        dist[destination] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i=0; i<map[cur].size(); i++){
                int next = map[cur].get(i);

                if(dist[next]==-1){
                    dist[next] = dist[cur]+1;
                    queue.add(next);
                }
            }
        }

        int[] answer = new int[sources.length];
        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}