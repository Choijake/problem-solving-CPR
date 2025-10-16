import java.util.*;

public class PG_20251016_최적의_행렬_곱셈 {

    class Solution {

        public int solution(int[][] matrix_sizes) {
            int[] matrixSizes = new int[matrix_sizes.length + 1];
            matrixSizes[0] = matrix_sizes[0][0];
            for (int i = 0; i < matrix_sizes.length; i++) {
                matrixSizes[i + 1] = matrix_sizes[i][1];
            }
            int[][] dp = new int[matrixSizes.length][matrixSizes.length];
            for (int[] row : dp) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int tail = 1; tail < matrixSizes.length; tail++) {
                dp[tail - 1][tail] = 0;
            }
            for (int tail = 2; tail < matrixSizes.length; tail++) {
                dp[tail - 2][tail] = matrixSizes[tail] * matrixSizes[tail - 1] * matrixSizes[tail - 2];
            }
            for (int windowSize = 4; windowSize <= matrixSizes.length; windowSize++) {
                for (int tail = windowSize - 1; tail < matrixSizes.length; tail++) {
                    int head = tail - windowSize + 1;
                    for (int border = head + 1; border < tail; border++) {
                        dp[head][tail] = Math.min(
                                dp[head][tail],
                                dp[head][border] + dp[border][tail] + (matrixSizes[head] * matrixSizes[border] * matrixSizes[tail]));
                    }
                }
            }
            return dp[0][matrixSizes.length - 1];
        }

    }

}
