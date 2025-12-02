import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = line.charAt(j-1)-'0';
            }
        }

        bfs();
    }

    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N+1][M+1];
        queue.add(new int[]{1, 1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0]==N&&cur[1]==M){
                System.out.println(cur[2]);
            }

            for(int i=0; i<4; i++){
                int nextRow = cur[0]+dr[i];
                int nextCol = cur[1]+dc[i];

                if(nextRow<1 || nextCol<1 || nextRow>N || nextCol>M)continue;
                if(map[nextRow][nextCol]!=1)continue;
                if(visited[nextRow][nextCol])continue;

                queue.add(new int[] {nextRow, nextCol, cur[2]+1});
                visited[nextRow][nextCol] = true;
            }
        }
    }
}
