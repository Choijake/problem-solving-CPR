
public class PG_20250716_입국심사 {

    class Solution {

        public long solution(int n, int[] times) {
            long maxTime = 0;
            for (int time : times) {
                if (maxTime < time) {
                    maxTime = time;
                }
            }
            long hi = maxTime * (long) n;
            long lo = 0;
            while (true) {
                if (hi - lo == 0) {
                    return hi;
                }
                if (hi - lo == 1) {
                    long cnt = 0;
                    for (long time : times) {
                        cnt += lo / time;
                    }
                    return (cnt < n) ? hi : lo;
                }
                long mid = (hi + lo) >> 1;
                long cnt = 0;
                for (long time : times) {
                    cnt += mid / time;
                    if (cnt >= n) {
                        break;
                    }
                }
                if (cnt < n) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }

    }


}
