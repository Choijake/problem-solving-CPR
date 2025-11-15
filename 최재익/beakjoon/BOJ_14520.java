import java.io.*;
import java.util.*;

public class BOJ_14520 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    static int N, M;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        combination(0);

        System.out.print(answer);
    }

    static void combination(int depth){
        if(depth == 3){
            bfs();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    combination(depth+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();

        int[][] copyMap = new int[N][M];
        for(int i=0; i<N; i++){
            copyMap[i] = map[i].clone();
            for(int j=0; j<M; j++){
                if(map[i][j]==2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=M)continue;
                if(copyMap[nr][nc]==2 || copyMap[nr][nc]==1)continue;

                copyMap[nr][nc] = 2;
                queue.add(new int[] {nr, nc});
            }
        }

        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyMap[i][j] == 0)count++;
            }
        }

        answer = Math.max(count, answer);
    }
}
