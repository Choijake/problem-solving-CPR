import java.util.*;

public class PG_20250915_3차_압축 {

    class Solution {

        public int[] solution(String msg) {
            List<String> words = new ArrayList<>();
            Map<String, Integer> wordIndices = new HashMap<>();
            for (char c = 'A'; c <= 'Z'; c++) {
                String s = String.valueOf(c);
                words.add(s);
                wordIndices.put(s, c - 'A');
            }
            List<Integer> answer = new ArrayList<>();
            char[] letters = msg.toCharArray();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            do {
                Set<String> keys = wordIndices.keySet();
                String newWord;
                do {
                    newWord = sb.append(letters[i]).toString();
                    if (!keys.contains(newWord)) {
                        break;
                    }
                    i++;
                } while (i < letters.length);
                if (i == letters.length) {
                    break;
                }
                answer.add(wordIndices.get(sb.deleteCharAt(sb.length() - 1).toString()));
                wordIndices.put(newWord, words.size());
                words.add(newWord);
                sb.delete(0, sb.length());
            } while (true);
            answer.add(wordIndices.get(sb.toString()));
            return answer.stream().mapToInt(e -> e + 1).toArray();
        }

    }

}
