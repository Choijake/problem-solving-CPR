import java.util.*;

public class PG_20250912_k진수에서_소수_개수_구하기 {

    class Solution {

        private static final int MAX_VALUE = 10_000_000;
        private static final boolean[] IS_PRIME = new boolean[MAX_VALUE];
        private static final Set<Integer> PRIMES = new HashSet<>();

        static {
            Arrays.fill(IS_PRIME, true);
            IS_PRIME[0] = IS_PRIME[1] = false;
            for (int base = 2; base < IS_PRIME.length; base++) {
                if (!IS_PRIME[base]) {
                    continue;
                }
                PRIMES.add(base);
                for (int multiple = base << 1; multiple < IS_PRIME.length; multiple += base) {
                    IS_PRIME[multiple] = false;
                }
            }
        }

        public int solution(int n, int k) {
            StringBuilder sb = new StringBuilder();
            sb.append(n % k);
            do {
                n /= k;
                sb.append(n % k);
            } while (n / k > 0);
            sb.reverse();
            int answer = 0;
            String[] numbers = sb.toString().split("0");
            for (String number : numbers) {
                if (number == null || number.length() == 0) {
                    continue;
                }
                long parsedNumber = Long.parseLong(number);
                if (parsedNumber > MAX_VALUE) {
                    if (isPrime(parsedNumber)) {
                        answer++;
                    }
                    continue;
                }
                if (IS_PRIME[(int) parsedNumber]) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean isPrime(long number) {
            for (int prime : PRIMES) {
                if (number % prime == 0) {
                    return false;
                }
            }
            long sqrt = (long) Math.sqrt(number);
            for (long i = MAX_VALUE; i <= sqrt; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

    }

}
