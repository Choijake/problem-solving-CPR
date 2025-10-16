
public class PG_20250925_2개_이하로_다른_비트 {

    class Solution {

        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                if ((1L & numbers[i]) == 0L) {
                    answer[i] = numbers[i] + 1L;
                    continue;
                }
                for (long shiftAmount = 0L; shiftAmount < 64L; shiftAmount++) {
                    long mask = 1L << shiftAmount;
                    if ((mask & numbers[i]) == 0L) {
                        answer[i] = numbers[i] + (mask >> 1L);
                        break;
                    }
                }
            }
            return answer;
        }

    }

}
