
public class PG_20251021_산_모양_타일링 {

    class Solution {

        private static final int[] MULTIPLE = { 3, 4 };

        public int solution(int n, int[] tops) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = (tops[0] == 0) ? 3 : 4;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] * MULTIPLE[tops[i - 1]] - dp[i - 2] + 10007) % 10007;
            }
            return dp[n];
        }

    }

}
