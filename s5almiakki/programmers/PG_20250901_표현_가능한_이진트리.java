
public class PG_20250901_표현_가능한_이진트리 {

    class Solution {

        public int[] solution(long[] numbers) {
            int[] result = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                long number = numbers[i];
                long leftLeafIdx = 1L;
                while (number >= (1L << leftLeafIdx)) {
                    leftLeafIdx <<= 1L;
                    if (leftLeafIdx >= 63) {
                        break;
                    }
                }
                leftLeafIdx -= 2L;
                if (dfs(number, leftLeafIdx, 0L)) {
                    result[i] = 1;
                }
            }
            return result;
        }

        private boolean dfs(long number, long leftLeafIdx, long rightLeafIdx) {
            if (rightLeafIdx >= leftLeafIdx) {
                return true;
            }
            long rootIdx = (leftLeafIdx + rightLeafIdx) >> 1L;
            if ((number & (1L << rootIdx)) != 0L) {
                return dfs(number, leftLeafIdx, rootIdx + 1L) && dfs(number, rootIdx - 1L, rightLeafIdx);
            }
            for (long validationMask = 1L << Math.min(leftLeafIdx, 64); validationMask >= (1L << rightLeafIdx); validationMask >>= 1L) {
                if ((number & validationMask) != 0L) {
                    return false;
                }
            }
            return true;
        }

    }

}
