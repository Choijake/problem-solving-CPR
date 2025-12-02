import java.util.*;

class PG_택배상자꺼내기 {
    static int[] dr = {0, 0};
    static int[] dc = {1, -1};
    public int solution(int n, int w, int num) {
        int height = n%w==0 ? n/w : n/w+1;
        int width = w;

        int[][] map = new int[height][width];
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                map[i][j] = -1;
            }
        }

        int row = height-1;
        int col = 0;

        int number = 1;
        int dir = 0;
        int[] location = new int[2];
        while(number<=n){
            if(number==num){
                location[0] = row;
                location[1] = col;
            }

            if(dir==0&&col==width-1){
                map[row--][col] = number++;
                dir = 1;
            }
            else if(dir==1&&col==0){
                map[row--][col] = number++;
                dir = 0;
            }
            else{
                if(dir==0)map[row][col++] = number++;
                else map[row][col--] = number++;
            }
        }

        int answer = 1;
        System.out.println(location[0]+" "+location[1]);
        for(int i=location[0]-1; i>=0; i--){
            if(map[i][location[1]] != -1){
                answer++;
            }
        }

        return answer;
    }
}