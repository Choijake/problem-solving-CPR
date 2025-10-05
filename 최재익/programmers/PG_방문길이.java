import java.util.*;

class PG_방문길이 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public int solution(String dirs) {
        int answer = 0;

        int row = 5;
        int col = 5;
        boolean[][][][] visited = new boolean[11][11][11][11];
        for(int i=0; i<dirs.length(); i++){
            int cmd = 0;
            if(dirs.charAt(i)=='U')cmd = 3;
            else if(dirs.charAt(i)=='D')cmd = 2;
            else if(dirs.charAt(i)=='R')cmd = 0;
            else if(dirs.charAt(i)=='L')cmd = 1;

            int nextRow = row+dr[cmd];
            int nextCol = col+dc[cmd];

            if(nextRow<0 || nextCol<0 || nextRow>10 || nextCol>10)continue;

            if(visited[row][col][nextRow][nextCol]){
                row = nextRow;
                col = nextCol;
                continue;
            }
            else{
                visited[row][col][nextRow][nextCol] = true;
                visited[nextRow][nextCol][row][col] = true;
                row = nextRow;
                col = nextCol;
                answer++;
            }
        }

        return answer;
    }
}