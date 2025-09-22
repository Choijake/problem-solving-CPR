
public class PG_20250917_카운트_다운 {

    class Solution {

        // [i][0]: value, [i][1]: singleScoreFlag
        private static final int[][] SCORES = {
                { 1, 1 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 5, 1 },
                { 6, 1 }, { 7, 1 }, { 8, 1 }, { 9, 1 }, { 10, 1 },
                { 11, 1 }, { 12, 1 }, { 13, 1 }, { 14, 1 }, { 15, 1 },
                { 16, 1 }, { 17, 1 }, { 18, 1 }, { 19, 1 }, { 20, 1 },
                { 21, 0 }, { 22, 0 }, { 24, 0 }, { 26, 0 }, { 27, 0 },
                { 28, 0 }, { 30, 0 }, { 32, 0 }, { 33, 0 }, { 34, 0 },
                { 36, 0 }, { 38, 0 }, { 39, 0 }, { 40, 0 }, { 42, 0 },
                { 45, 0 }, { 48, 0 }, { 50, 1 }, { 51, 0 }, { 54, 0 },
                { 57, 0 }, { 60, 0 },
        };

        public int[] solution(int target) {
            int[][] dp = new int[target + 1][2];
            for (int[] element : dp) {
                element[0] = Integer.MAX_VALUE;
            }
            dp[0][0] = 0;
            dp[0][1] = 0;
            for (int[] score : SCORES) {
                int base = 0;
                int newScore = score[0];
                while (newScore <= target) {
                    if (base == Integer.MAX_VALUE) {
                        continue;
                    }
                    int newDartCount = dp[base][0] + 1;
                    if (newDartCount < dp[newScore][0]) {
                        dp[newScore][0] = newDartCount;
                        dp[newScore][1] = dp[base][1] + score[1];
                    } else if (newDartCount == dp[newScore][0]) {
                        dp[newScore][1] = Math.max(dp[newScore][1], dp[base][1] + score[1]);
                    }
                    base++;
                    newScore++;
                }
            }
            return dp[target];
        }

    }

}
