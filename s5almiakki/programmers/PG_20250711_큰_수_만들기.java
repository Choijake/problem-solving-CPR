import java.util.*;

public class PG_20250711_큰_수_만들기 {

    class Solution1 {

        public String solution(String number, int k) {
            Deque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                if (k == 0 || deque.isEmpty() || deque.peek() >= c) {
                    deque.push(c);
                    continue;
                }
                deque.pop();
                k--;
                i--;
            }
            while (k != 0) {
                deque.pop();
                k--;
            }
            StringBuilder result = new StringBuilder();
            for (char c : deque) {
                result.append(c);
            }
            return result.reverse().toString();
        }

    }

    class Solution2 {

        public String solution(String number, int k) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < number.length(); i++) {
                char c = number.charAt(i);
                if (k == 0 || result.length() == 0 || result.charAt(result.length() - 1) >= c) {
                    result.append(c);
                    continue;
                }
                result.deleteCharAt(result.length() - 1);
                k--;
                i--;
            }
            while (k != 0) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }
            return result.toString();
        }

    }

}
