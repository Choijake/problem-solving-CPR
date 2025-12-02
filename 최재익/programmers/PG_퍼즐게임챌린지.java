import java.util.*;

class PG_퍼즐게임챌린지 {
    private static int[] diffs;
    private static int[] times;

    public long solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;

        long lo = 0L;
        long hi = 0L;
        for(int diff : diffs){
            hi = Math.max(hi, diff);
        }

        while(lo+1<hi){
            long mid = (lo+hi)/2;
            long totalTime = getTotalTime(mid);

            if(totalTime>limit){
                lo = mid;
            }
            else if(totalTime<=limit){
                hi = mid;
            }
        }

        return hi;
    }

    public long getTotalTime(long level){
        long totalTime=0;
        for(int i=0; i<diffs.length; i++){
            long partTime = 0L;
            long wrongCount=0L;
            long cost=0L;

            if(diffs[i]<=level)partTime = times[i];
            else{
                wrongCount = diffs[i]-level;
                cost = i==0?times[i]:times[i]+times[i-1];
                partTime = wrongCount*cost+times[i];
            }

            totalTime+=partTime;
        }
        return totalTime;
    }
}