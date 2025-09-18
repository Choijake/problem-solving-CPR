import java.util.*;

public class PG_20250918_스킬트리 {

    class Solution {

        public int solution(String skill, String[] skill_trees) {
            int[] indices = new int[26];
            Arrays.fill(indices, -1);
            char[] skillLetters = skill.toCharArray();
            for (int i = 0; i < skillLetters.length; i++) {
                indices[skillLetters[i] - 'A'] = i;
            }
            int answer = 0;
            for (String skillTree : skill_trees) {
                boolean possible = true;
                int prevIdx = -1;
                for (int i = 0; i < skillTree.length(); i++) {
                    int idx = indices[skillTree.charAt(i) - 'A'];
                    if (idx == -1) {
                        continue;
                    }
                    if (idx - prevIdx != 1) {
                        possible = false;
                        break;
                    }
                    prevIdx = idx;
                }
                if (possible) {
                    answer++;
                }
            }
            return answer;
        }

    }

}
