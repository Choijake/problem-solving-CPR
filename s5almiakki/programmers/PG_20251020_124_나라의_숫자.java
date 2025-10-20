
public class PG_20251020_124_나라의_숫자 {

    class Solution {

        private static final char[] numbers = { '1', '2', '4' };

        public String solution(int n) {
            StringBuilder answer = new StringBuilder();
            while (n > 0) {
                answer.append(numbers[(n + 2) % 3]);
                n = (n - 1) / 3;
            }
            return answer.reverse().toString();
        }

    }

}
