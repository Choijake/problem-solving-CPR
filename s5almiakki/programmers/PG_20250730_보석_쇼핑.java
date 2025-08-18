import java.util.*;

public class PG_20250730_보석_쇼핑 {

    class Solution {

        public int[] solution(String[] gems) {
            Set<String> kinds = new HashSet<>();
            for (String gem : gems) {
                kinds.add(gem);
            }
            int totalKindCnt = kinds.size();
            Map<String, Integer> chosenGemCnts = new HashMap<>();
            int lo = 0;
            int hi = 0;
            chosenGemCnts.put(gems[0], 1);
            int[] answer = { -1, gems.length };
            do {
                int chosenKindCnt = chosenGemCnts.size();
                if (chosenKindCnt < totalKindCnt) {
                    hi++;
                    if (hi == gems.length) {
                        break;
                    }
                    chosenGemCnts.put(gems[hi], chosenGemCnts.getOrDefault(gems[hi], 0) + 1);
                } else {
                    int loGemCnt = chosenGemCnts.get(gems[lo]);
                    if (loGemCnt == 1) {
                        chosenGemCnts.remove(gems[lo]);
                    } else {
                        chosenGemCnts.put(gems[lo], loGemCnt - 1);
                    }
                    if (hi - lo < answer[1] - answer[0]) {
                        answer[0] = lo;
                        answer[1] = hi;
                    }
                    lo++;
                    if (lo == gems.length) {
                        break;
                    }
                }
            } while (lo < gems.length);
            answer[0]++;
            answer[1]++;
            return answer;
        }

    }

}
