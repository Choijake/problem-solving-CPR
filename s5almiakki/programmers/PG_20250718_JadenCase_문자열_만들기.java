
public class PG_20250718_JadenCase_문자열_만들기 {

    class Solution {

        public String solution(String s) {
            String[] words = s.split(" ", -1);
            StringBuilder answer = new StringBuilder();
            for (String word : words) {
                if (word.length() == 0) {
                    answer.append(' ');
                    continue;
                }
                char[] letters = word.toCharArray();
                if ('a' <= letters[0] && letters[0] <= 'z') {
                    letters[0] = Character.toUpperCase(letters[0]);
                }
                for (int i = 1; i < letters.length; i++) {
                    if ('A' <= letters[i] && letters[i] <= 'Z') {
                        letters[i] = Character.toLowerCase(letters[i]);
                    }
                }
                answer.append(letters).append(' ');
            }
            answer.deleteCharAt(answer.length() - 1);
            return answer.toString();
        }

    }

}
