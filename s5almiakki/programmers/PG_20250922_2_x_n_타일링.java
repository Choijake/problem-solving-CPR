
public class PG_20250922_2_x_n_타일링 {

    class Solution {

        public int solution(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            long[] dp = new long[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_007L;
            }
            return (int) dp[n];
        }

    }

}
