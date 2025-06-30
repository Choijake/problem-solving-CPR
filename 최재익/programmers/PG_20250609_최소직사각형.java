import java.util.*;

class PG_20250609_최소직사각형 {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;

        //길면 가로 짧으면 세로
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0]<sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            width = Math.max(width, sizes[i][0]);
            height = Math.max(height, sizes[i][1]);
        }

        return width*height;
    }
}
