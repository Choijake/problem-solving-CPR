import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7576 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static List<int[]> starts;
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        starts = new ArrayList<>();
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)starts.add(new int[]{i, j});
            }
        }

        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[N][M];
        for(int[] arr : starts){
            queue.add(new int[] {arr[0], arr[1]});
            visited[arr[0]][arr[1]] = 0;
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nextRow = cur[0] + dr[i];
                int nextCol = cur[1] + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=N || nextCol>=M)continue;
                if(map[nextRow][nextCol] !=0)continue;

                queue.add(new int[] {nextRow, nextCol});
                map[nextRow][nextCol] = 1;
                visited[nextRow][nextCol] = visited[cur[0]][cur[1]]+1;
            }
        }

        int days = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, visited[i][j]);
            }
        }
        System.out.println(days);
    }
}
