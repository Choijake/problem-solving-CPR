public class PG_20250911_3차_n진수_게임 {


    class Solution {

        private static final char[] NUMBERS = new char[16];

        static {
            for (int i = 0; i < 10; i++) {
                NUMBERS[i] = (char) ('0' + i);
            }
            for (int i = 0; i < 6; i++) {
                NUMBERS[i + 10] = (char) ('A' + i);
            }
        }

        public String solution(int n, int t, int m, int p) {
            p--;
            int currentOrder = 0;
            int currentNumber = 0;
            StringBuilder result = new StringBuilder();
            do {
                int[] indices = toIdxArray(currentNumber, n);
                for (int idx : indices) {
                    if (currentOrder == p) {
                        result.append(NUMBERS[idx]);
                        if (result.length() == t) {
                            return result.toString();
                        }
                    }
                    currentOrder = (currentOrder + 1) % m;
                }
                currentNumber++;
            } while (true);
        }

        private int computeLetterCount(int number, int base) {
            int count = 1;
            while (number / base > 0) {
                number /= base;
                count++;
            }
            return count;
        }

        private int[] toIdxArray(int number, int base) {
            int[] result = new int[computeLetterCount(number, base)];
            for (int i = result.length - 1; i >= 0; i--) {
                result[i] = number % base;
                number /= base;
            }
            return result;
        }

    }

}
