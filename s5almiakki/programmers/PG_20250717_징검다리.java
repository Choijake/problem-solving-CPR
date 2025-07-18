import java.util.*;

public class PG_20250717_징검다리 {

    class Solution {

        public int solution(int distance, int[] rocks, int n) {
            Arrays.sort(rocks);
            int[] points = new int[rocks.length + 2];
            points[0] = 0;
            points[points.length - 1] = distance;
            System.arraycopy(rocks, 0, points, 1, rocks.length);
            int hi = distance;
            int lo = 0;
            int answer = 0;
            do {
                int removalCnt = 0;
                int prevPoint = 0;
                int mid = (hi + lo) >> 1;
                for (int i = 1; i < points.length; i++) {
                    if (points[i] - prevPoint >= mid) {
                        prevPoint = points[i];
                        continue;
                    }
                    removalCnt++;
                    if (removalCnt > n) {
                        break;
                    }
                }
                if (removalCnt <= n) {
                    lo = mid + 1;
                    answer = mid;
                } else {
                    hi = mid - 1;
                }
            } while (lo <= hi);
            return answer;
        }

    }

}
