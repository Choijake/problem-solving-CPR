
public class PG_20250821_멀리_뛰기 {

    class Solution {

        public long solution(int n) {
            if (n <= 3) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < dp.length; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
            }
            return dp[n];
        }

    }

}
