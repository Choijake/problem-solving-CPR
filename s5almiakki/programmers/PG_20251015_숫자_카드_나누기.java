import java.util.*;

public class PG_20251015_숫자_카드_나누기 {

    class Solution {

        private static final int MAX_INT = 100_000_000;
        private static final boolean[] prime = new boolean[MAX_INT + 1];
        private static final List<Integer> primes = new ArrayList<>();
        static {
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;
            for (int i = 2; i <= MAX_INT; i++) {
                if (!prime[i]) {
                    continue;
                }
                primes.add(i);
                for (int j = i << 1; j <= MAX_INT; j += i) {
                    prime[j] = false;
                }
            }
        }

        private int answer = 0;

        public int solution(int[] arrayA, int[] arrayB) {
            int[] arrayACopy = Arrays.copyOf(arrayA, arrayA.length);
            int[] arrayBCopy = Arrays.copyOf(arrayB, arrayB.length);
            int gcdA = 1;
            int gcdB = 1;
            for (int num : primes) {
                while (canDivideAll(num, arrayACopy)) {
                    gcdA *= num;
                    for (int i = 0; i < arrayACopy.length; i++) {
                        arrayACopy[i] /= num;
                    }
                }
                while (canDivideAll(num, arrayBCopy)) {
                    gcdB *= num;
                    for (int i = 0; i < arrayBCopy.length; i++) {
                        arrayBCopy[i] /= num;
                    }
                }
            }
            if (!hasDivisibleNum(arrayA, gcdB)) {
                answer = Math.max(answer, gcdB);
            }
            if (!hasDivisibleNum(arrayB, gcdA)) {
                answer = Math.max(answer, gcdA);
            }
            return answer;
        }

        private boolean canDivideAll(int divisor, int[] dividends) {
            for (int dividend : dividends) {
                if (dividend % divisor != 0) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasDivisibleNum(int[] dividends, int divisor) {
            for (int dividend : dividends) {
                if (dividend % divisor == 0) {
                    return true;
                }
            }
            return false;
        }

    }

}
