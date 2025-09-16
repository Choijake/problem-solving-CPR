
public class PG_20250916_땅따먹기 {

    class Solution {

        int solution(int[][] land) {
            int[][] dp = new int[land.length][4];
            for (int i = 0; i < dp[0].length; i++) {
                dp[0][i] = land[0][i];
            }
            for (int row = 1; row < dp.length; row++) {
                for (int col = 0; col < 4; col++) {
                    int max = Integer.MIN_VALUE;
                    for (int colOffset = -3; colOffset <= 3; colOffset++) {
                        if (colOffset == 0) {
                            continue;
                        }
                        int c = col + colOffset;
                        if (c < 0 || 4 <= c) {
                            continue;
                        }
                        max = Math.max(max, dp[row - 1][c]);
                    }
                    dp[row][col] = land[row][col] + max;
                }
            }
            int answer = dp[dp.length - 1][0];
            for (int i = 1; i < 4; i++) {
                answer = Math.max(answer, dp[dp.length - 1][i]);
            }
            return answer;
        }

    }

}
