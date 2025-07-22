
public class PG_20250715_도둑질 {

    class Solution {

        public int solution(int[] money) {
            // [0]: 마지막 집 미포함, [1]: 마지막 집 포함
            int[][] dp = new int[2][money.length];
            dp[0][0] = money[0];
            dp[0][1] = Math.max(money[0], money[1]);
            dp[0][2] = Math.max(
                    dp[0][0] + money[2],
                    dp[0][1]);
            dp[1][1] = money[1];
            dp[1][2] = Math.max(money[1], money[2]);
            for (int i = 0; i < 2; i++) {
                for (int j = 3; j < money.length - 1; j++) {
                    dp[i][j] = Math.max(
                            dp[i][j - 2] + money[j],
                            dp[i][j - 1]);
                }
            }
            dp[1][money.length - 1] = Math.max(
                    dp[1][money.length - 3] + money[money.length - 1],
                    dp[1][money.length - 2]);
            return Math.max(
                    dp[0][money.length - 2],
                    dp[1][money.length - 1]);
        }

    }

}
