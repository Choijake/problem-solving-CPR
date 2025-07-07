
public class PG_20250707_등굣길 {

    class Solution {

        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[m + 1][n + 1];
            for (int[] puddle : puddles) {
                dp[puddle[0]][puddle[1]] = -1;
            }
            dp[1][1] = 1;
            for (int x = 1; x <= m; x++) {
                for (int y = 1; y <= n; y++) {
                    if (dp[x][y] == -1) {
                        continue;
                    }
                    if (dp[x - 1][y] != -1) {
                        dp[x][y] = (dp[x][y] + dp[x - 1][y]) % 1_000_000_007;
                    }
                    if (dp[x][y - 1] != -1) {
                        dp[x][y] = (dp[x][y] + dp[x][y - 1]) % 1_000_000_007;
                    }
                }
            }
            return dp[m][n] % 1_000_000_007;
        }

    }

}
