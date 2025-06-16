import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1926 {
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    private static int pictureCount;
    private static int maxSize;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       map = new int[N][M];
       visited = new boolean[N][M];
       for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<M; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       pictureCount = 0;
       maxSize = 0;
       for(int i=0; i<N; i++){
           for(int j=0; j<M; j++){
               if(!visited[i][j]&&map[i][j]==1){
                   pictureCount++;
                   bfs(i, j);
               }
           }
       }

       System.out.println(pictureCount+"\n"+maxSize);
    }

    private static void bfs(int row, int col){
        int size = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for(int i=0; i<4; i++){
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=N || nextCol>=M)continue;
                if(map[nextRow][nextCol]!=1)continue;
                if(visited[nextRow][nextCol])continue;

                queue.add(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol] = true;
                size++;
            }
        }

        maxSize = Math.max(maxSize, size);
    }
}
