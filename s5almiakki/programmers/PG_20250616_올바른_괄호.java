import java.util.*;

public class PG_20250616_올바른_괄호 {

    class Solution {

        boolean solution(String s) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                        deque.push(c);
                        break;
                    case ')':
                        if (deque.isEmpty() || deque.peek() != '(') {
                            return false;
                        }
                        deque.pop();
                        break;
                    default:
                        return false;
                }
            }
            return deque.isEmpty();
        }

    }

}
