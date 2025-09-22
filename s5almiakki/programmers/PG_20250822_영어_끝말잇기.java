import java.util.*;

public class PG_20250822_영어_끝말잇기 {

    class Solution {

        public int[] solution(int n, String[] words) {
            if (words[0].length() == 1) {
                return new int[] { 1, 0 };
            }
            Set<String> saidWords = new HashSet<>();
            int answer = -1;
            String previousWord = words[0];
            saidWords.add(words[0]);
            for (int order = 1; order < words.length; order++) {
                String currentWord = words[order];
                if (currentWord.length() == 1
                        || previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)
                        || saidWords.contains(currentWord)) {
                    answer = order;
                    break;
                }
                previousWord = currentWord;
                saidWords.add(currentWord);
            }
            if (answer == -1) {
                return new int[] { 0, 0 };
            }
            return new int[] { (answer % n) + 1, (answer / n) + 1 };
        }

    }

}
