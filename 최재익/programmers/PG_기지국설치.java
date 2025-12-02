import java.util.*;

class PG_기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int range = 0, count = 0;

        for(int station : stations){
            int left = station-w;
            int right = station+w;

            if(range<left){
                int space = left-range-1;
                count += install(space, w);
                range = right;
            }
            else{
                range = Math.max(range, right);
            }
        }

        if(range<n){
            int space = n-range;
            count += install(space, w);
        }

        return count;
    }

    static int install(int space, int w){
        int need = 2*w+1;
        return (space%need==0)?space/need:space/need+1;
    }
}