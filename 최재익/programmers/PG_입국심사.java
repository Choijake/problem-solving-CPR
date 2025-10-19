import java.util.*;

class PG_입국심사 {
    public long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;

        Arrays.sort(times);
        long lo = 0;
        long hi = (long)n*times[times.length-1];

        while(lo+1<hi){
            long mid = (lo+hi)/2;
            long accept = check(mid, times);

            if(accept < n)lo=mid;
            else{
                answer = mid;
                hi=mid;
            }
        }

        return answer;
    }

    static long check(long mid, int[] times){
        long count = 0;
        for(int t : times){
            count += mid/(long)t;
        }
        return count;
    }
}