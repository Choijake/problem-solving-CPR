import java.util.*;

public class PG_20250719_짝지어_제거하기 {

    class Solution {

        public int solution(String s) {
            char[] letters = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            for (char letter : letters) {
                if (stack.isEmpty()) {
                    stack.push(letter);
                    continue;
                }
                if (stack.peek().equals(letter)) {
                    stack.pop();
                } else {
                    stack.push(letter);
                }
            }
            return stack.isEmpty() ? 1 : 0;
        }

    }

}
