import java.util.*;

class PG_석유시추 {
    static int N, M;
    static List<int[]> location;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] land;
    static int[] sum;
    public int solution(int[][] land) {
        this.land = land;
        N = land.length;
        M = land[0].length;

        sum = new int[M];
        visited = new boolean[N][M];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(land[j][i]==1){
                    if(visited[j][i])continue;
                    bfs(j, i);
                }
            }
        }

        Arrays.sort(sum);

        return sum[M-1];
    }

    public void bfs(int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int extent = 1;
        int maxCol = col;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nextRow = cur[0] + dr[i];
                int nextCol = cur[1] + dc[i];

                if(nextRow<0||nextCol<0||nextRow>=N||nextCol>=M)continue;
                if(visited[nextRow][nextCol])continue;
                if(land[nextRow][nextCol]!=1)continue;

                queue.add(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol] = true;
                extent++;

                maxCol = Math.max(maxCol, nextCol);
            }
        }

        for(int i=col; i<=maxCol; i++){
            sum[i] += extent;
        }
    }
}