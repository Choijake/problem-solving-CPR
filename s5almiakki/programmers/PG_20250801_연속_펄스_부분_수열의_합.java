
public class PG_20250801_연속_펄스_부분_수열의_합 {

    class Solution {

        public long solution(int[] sequence) {
            long sign = 1L;
            long[] accumulations = new long[sequence.length];
            long result = Integer.MIN_VALUE;
            for (int i = 0; i < 2; i++) {
                accumulations[0] = sequence[0] * sign;
                result = Math.max(result, accumulations[0]);
                long minAccumulation = accumulations[0];
                for (int j = 1; j < sequence.length; j++) {
                    sign = -sign;
                    accumulations[j] = (sign * sequence[j]) + accumulations[j - 1];
                    result = selectMax(result, accumulations[j], accumulations[j] - minAccumulation);
                    minAccumulation = Math.min(minAccumulation, accumulations[j]);
                }
                sign = -1L;
            }
            return result;
        }

        private long selectMax(long... values) {
            long result = values[0];
            for (int i = 1; i < values.length; i++) {
                result = Math.max(result, values[i]);
            }
            return result;
        }

    }

}
