
public class PG_20250804_거스름돈 {

    class Solution {

        public int solution(int n, int[] money) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int value : money) {
                for (int i = 1; i <= n; i++) {
                    if (i - value >= 0) {
                        dp[i] = (dp[i] + dp[i - value]) % 1_000_000_007;
                    }
                }
            }
            return dp[n];
        }

    }

}
