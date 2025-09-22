
public class PG_20250819_보행자_천국 {

    class Solution {

        int MOD = 20170805;

        public int solution(int m, int n, int[][] cityMap) {
            int[][][] dp = new int[m][n][2]; // 0: 아래로, 1: 오른쪽으로
            dp[0][0][0] = 1;
            dp[0][0][1] = 1;
            for (int col = 1; col < n; col++) {
                if (cityMap[0][col] == 1) {
                    break;
                }
                if (cityMap[0][col] == 0) {
                    dp[0][col][0] += dp[0][col - 1][1];
                    dp[0][col][0] %= MOD;
                }
                dp[0][col][1] += dp[0][col - 1][1];
                dp[0][col][1] %= MOD;
            }
            for (int row = 1; row < m; row++) {
                if (cityMap[row][0] != 1) {
                    dp[row][0][0] += dp[row - 1][0][0];
                    dp[row][0][0] %= MOD;
                    if (cityMap[row][0] == 0) {
                        dp[row][0][1] += dp[row - 1][0][0];
                        dp[row][0][1] %= MOD;
                    }
                }
                for (int col = 1; col < n; col++) {
                    if (cityMap[row][col] == 1) {
                        continue;
                    }
                    dp[row][col][0] += dp[row - 1][col][0];
                    dp[row][col][1] += dp[row][col - 1][1];
                    dp[row][col][0] %= MOD;
                    dp[row][col][1] %= MOD;
                    if (cityMap[row][col] == 0) {
                        dp[row][col][0] += dp[row][col - 1][1];
                        dp[row][col][1] += dp[row - 1][col][0];
                        dp[row][col][0] %= MOD;
                        dp[row][col][1] %= MOD;
                    }
                }
            }
            return dp[m - 1][n - 1][0];
        }
    }

}
