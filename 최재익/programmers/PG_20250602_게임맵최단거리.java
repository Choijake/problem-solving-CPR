import java.util.*;

class PG_20250602_게임맵최단거리 {
    private int[] dr = {0, 0, 1, -1};
    private int[] dc = {1, -1, 0, 0};
    private int[][] maps;
    private int N, M;

    public int solution(int[][] maps) {
        this.maps = maps;
        this.N = maps.length;
        this.M = maps[0].length;
        return bfs();
    }

    public int bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            int sum = cur[2];

            if(checkEndPoint(curRow, curCol)){
                return sum;
            }

            for(int i=0; i<4; i++){
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];

                if(!checkRange(nextRow, nextCol) || visited[nextRow][nextCol]){
                    continue;
                }

                if(checkWalkable(nextRow, nextCol)){
                    queue.add(new int[] {nextRow, nextCol, sum+1});
                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return -1;
    }

    private boolean checkRange(int row, int col){
        return row>=0 && col>=0 && row<N && col<M;
    }

    private boolean checkWalkable(int row, int col){
        return maps[row][col] == 1;
    }

    private boolean checkEndPoint(int row, int col){
        return row==N-1 && col==M-1;
    }
}
