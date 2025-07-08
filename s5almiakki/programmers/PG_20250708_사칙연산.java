
public class PG_20250708_사칙연산 {

    class Solution {

        public int solution(String arr[]) {
            int operandCnt = (arr.length >> 1) + 1;
            // dpMax[i][j]: i번째부터 j번째까지의 피연산자를 계산한 것 중 최댓값
            // dpMin[i][j]: i번째부터 j번째까지의 피연산자를 계산한 것 중 최솟값
            int[][] dpMax = new int[operandCnt][operandCnt];
            int[][] dpMin = new int[operandCnt][operandCnt];
            for (int i = 0; i < operandCnt; i++) {
                dpMax[i][i] = Integer.parseInt(arr[i << 1]);
                dpMin[i][i] = Integer.parseInt(arr[i << 1]);
            }
            for (int length = 1; length < operandCnt; length++) {
                for (int start = 0; start < operandCnt - length; start++) {
                    int end = start + length;
                    dpMax[start][end] = Integer.MIN_VALUE;
                    dpMin[start][end] = Integer.MAX_VALUE;
                    for (int idx = start; idx < end; idx++) {
                        String operator = arr[(idx << 1) + 1];
                        int maxLeft = dpMax[start][idx];
                        int minLeft = dpMin[start][idx];
                        int maxRight = dpMax[idx + 1][end];
                        int minRight = dpMin[idx + 1][end];
                        switch (operator) {
                        case "+":
                            dpMax[start][end] = Math.max(dpMax[start][end], maxLeft + maxRight);
                            dpMin[start][end] = Math.min(dpMin[start][end], minLeft + minRight);
                            break;
                        case "-":
                            dpMax[start][end] = Math.max(dpMax[start][end], maxLeft - minRight);
                            dpMin[start][end] = Math.min(dpMin[start][end], minLeft - maxRight);
                            break;
                        }
                    }
                }
            }
            return dpMax[0][operandCnt - 1];
        }

    }

}
