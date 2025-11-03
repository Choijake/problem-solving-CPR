import java.util.*;

public class PG_20251027_봉인된_주문 {

    class Solution {

        private final static long ALPHABET_COUNT = 26L;
        private final static long[] POWS = new long[12];

        static {
            POWS[0] = 1;
            for (int i = 1; i < POWS.length; i++) {
                POWS[i] = POWS[i - 1] * ALPHABET_COUNT;
            }
        }

        public String solution(long n, String[] bans) {
            Arrays.sort(bans, (o1, o2) -> (o1.length() == o2.length()) ? o1.compareTo(o2) : o1.length() - o2.length());
            for (String bannedWord : bans) {
                long wordIdx = bannedWord.charAt(bannedWord.length() - 1) - 'a' + 1;
                for (int i = 0; i < bannedWord.length() - 1; i++) {
                    wordIdx += POWS[bannedWord.length() - i - 1]
                            * (bannedWord.charAt(i) - 'a' + 1);
                }
                if (wordIdx <= n) {
                    n++;
                }
            }
            StringBuilder answer = new StringBuilder();
            while (n > 0) {
                n--;
                answer.append((char) ('a' + (n % ALPHABET_COUNT)));
                n /= ALPHABET_COUNT;
            }
            return answer.reverse().toString();
        }

    }

}
