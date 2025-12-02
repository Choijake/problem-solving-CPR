import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
    static int min = Integer.MAX_VALUE;
    static int F, S, G;
    static int[] dir = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[F+1];
        queue.add(new int[]{S, 0});
        visited[S] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==G){
                min = Math.min(min, cur[1]);
                continue;
            }

            for(int i=0; i<2; i++){
                int nextFloor = cur[0]+dir[i];

                if(nextFloor<1 || nextFloor>F)continue;
                if(visited[nextFloor])continue;

                queue.add(new int[]{nextFloor, cur[1]+1});
                visited[nextFloor]=true;
            }
        }

        if(min==Integer.MAX_VALUE){
            System.out.println("use the stairs");
            return;
        }
        System.out.println(min);
    }
}
