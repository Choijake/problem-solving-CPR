
public class PG_20250829_괄호_회전하기 {

    class Solution {

        public int solution(String s) {
            StringBuilder target = new StringBuilder(s);
            int answer = 0;
            for (int i = 0; i < s.length(); i++) {
                if (isValid(target)) {
                    answer++;
                }
                target.append(target.charAt(0))
                .deleteCharAt(0);
            }
            return answer;
        }

        private boolean isValid(StringBuilder target) {
            StringBuilder stack = new StringBuilder();
            for (int i = 0; i < target.length(); i++) {
                char bracket = target.charAt(i);
                switch (bracket) {
                    case '(': // fall through
                    case '[': // fall through
                    case '{':
                        stack.append(bracket);
                        break;
                    case ')':
                        if (stack.length() == 0 || stack.charAt(stack.length() - 1) != '(') {
                            return false;
                        }
                        stack.deleteCharAt(stack.length() - 1);
                        break;
                    case ']':
                        if (stack.length() == 0 || stack.charAt(stack.length() - 1) != '[') {
                            return false;
                        }
                        stack.deleteCharAt(stack.length() - 1);
                        break;
                    case '}':
                        if (stack.length() == 0 || stack.charAt(stack.length() - 1) != '{') {
                            return false;
                        }
                        stack.deleteCharAt(stack.length() - 1);
                        break;
                }
            }
            return stack.length() == 0;
        }

    }

}
