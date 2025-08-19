import java.util.*;

public class PG_20250819_귤_고르기 {

    class Solution {

        public int solution(int k, int[] tangerine) {
            int[] tangerineCnts = new int[10_000_001];
            for (int tangerineSize : tangerine) {
                tangerineCnts[tangerineSize]++;
            }
            Arrays.sort(tangerineCnts);
            int answer = 0;
            for (int i = tangerineCnts.length - 1; i >= 0; i--) {
                k -= tangerineCnts[i];
                answer++;
                if (k <= 0) {
                    break;
                }
            }
            return answer;
        }

    }

}
