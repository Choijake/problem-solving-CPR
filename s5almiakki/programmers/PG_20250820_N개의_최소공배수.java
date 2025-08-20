import java.util.*;

public class PG_20250820_N개의_최소공배수 {

    class Solution {

        private static final int MAX = 100;
        private static final List<Integer> PRIMES = new ArrayList<>();

        static {
            int[] primeStates = new int[MAX + 1];
            for (int i = 2; i <= MAX; i++) {
                if (primeStates[i] != 0) {
                    continue;
                }
                primeStates[i] = 1;
                PRIMES.add(i);
                for (int j = i << 1; j <= MAX; j += i) {
                    primeStates[j] = -1;
                }
            }
        }

        public int solution(int[] arr) {
            int[] primeCnts = new int[MAX + 1];
            for (int num : arr) {
                for (int prime : PRIMES) {
                    int primeCnt = 0;
                    while (num % prime == 0) {
                        num /= prime;
                        primeCnt++;
                    }
                    primeCnts[prime] = Math.max(primeCnts[prime], primeCnt);
                }
            }
            int answer = 1;
            for (int prime : PRIMES) {
                for (int i = 0; i < primeCnts[prime]; i++) {
                    answer *= prime;
                }
            }
            return answer;
        }

    }

}
