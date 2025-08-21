import java.util.*;

class PG_프렌즈4블록 {
    char[][] map;
    int m, n;

    public int solution(int height, int width, String[] board) {
        m = height;
        n = width;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int totalRemovedCount = 0;
        while(true){
            boolean[][] toRemove = new boolean[m][n];
            int currentRoundRemovedCount = 0;

            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    char block = map[i][j];
                    if(block!=' '&&block==map[i+1][j]&&block==map[i][j+1]&&block==map[i+1][j+1]){
                        toRemove[i][j]=true;
                        toRemove[i][j+1] = true;
                        toRemove[i+1][j] = true;
                        toRemove[i+1][j+1] = true;
                    }
                }
            }

            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(toRemove[i][j]){
                        map[i][j]=' ';
                        currentRoundRemovedCount++;
                    }
                }
            }

            if(currentRoundRemovedCount==0)break;

            totalRemovedCount+=currentRoundRemovedCount;

            dropBlocks();
        }

        return totalRemovedCount;
    }

    private void dropBlocks() {
        for(int j=0; j<n; j++){
            int writeIdx = m-1;
            for(int i=m-1; i>=0; i--){
                if(map[i][j]!=' '){
                    char tmp = map[i][j];
                    map[i][j] = ' ';
                    map[writeIdx][j] = tmp;
                    writeIdx--;
                }
            }
        }
    }
}