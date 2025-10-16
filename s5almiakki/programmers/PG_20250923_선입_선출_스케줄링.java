
public class PG_20250923_선입_선출_스케줄링 {

    class Solution {

        public int solution(int n, int[] cores) {
            int high = n * max(cores);
            int low = 0;
            int completionTime = -1;
            int finalProcessCnt = -1;
            do {
                int mid = (high + low) >> 1;
                int processCnt = cores.length;
                for (int core : cores) {
                    processCnt += mid / core;
                }
                if (processCnt >= n) {
                    completionTime = mid;
                    finalProcessCnt = processCnt;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } while (low <= high);
            int processCntDiff = finalProcessCnt - n;
            int answer = 0;
            for (int i = cores.length - 1; i >= 0; i--) {
                if (completionTime % cores[i] != 0) {
                    continue;
                }
                if (processCntDiff == 0) {
                    answer = i;
                    break;
                }
                processCntDiff--;
            }
            return answer + 1;
        }

        private int max(int... values) {
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < values.length; i++) {
                result = Math.max(result, values[i]);
            }
            return result;
        }

    }


}
