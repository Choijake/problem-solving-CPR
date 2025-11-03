import java.util.*;

public class PG_20251027_자연수_뒤집어_배열로_만들기 {

    class Solution1 {

        public int[] solution(long n) {
            Queue<Integer> queue = new ArrayDeque<>();
            while (n > 0) {
                queue.add((int) (n % 10L));
                n /= 10L;
            }
            int[] answer = new int[queue.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = queue.remove();
            }
            return answer;
        }

    }

    class Solution2 {

        public int[] solution(long n) {
            String s = String.valueOf(n);
            int[] answer = new int[s.length()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = s.charAt(s.length() - i - 1) - '0';
            }
            return answer;
        }

    }

}
