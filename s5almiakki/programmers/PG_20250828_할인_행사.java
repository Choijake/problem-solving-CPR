import java.util.*;

public class PG_20250828_할인_행사 {

    class Solution {

        public int solution(String[] want, int[] number, String[] discount) {
            Map<String, Integer> wantedItemCounts = new HashMap<>();
            for (int i = 0; i < want.length; i++) {
                wantedItemCounts.put(want[i], number[i]);
            }
            Map<String, Integer> windowItemCounts = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                windowItemCounts.put(discount[i], windowItemCounts.getOrDefault(discount[i], 0) + 1);
            }
            int head = 9;
            int tail = 0;
            int answer = 0;
            do {
                boolean wanted = true;
                for (Map.Entry<String, Integer> wantedItemCount : wantedItemCounts.entrySet()) {
                    if (wantedItemCount.getValue() > windowItemCounts.getOrDefault(wantedItemCount.getKey(), 0)) {
                        wanted = false;
                        break;
                    }
                }
                if (wanted) {
                    answer++;
                }
                if (head == discount.length - 1) {
                    break;
                }
                head++;
                windowItemCounts.put(discount[head], windowItemCounts.getOrDefault(discount[head], 0) + 1);
                windowItemCounts.put(discount[tail], windowItemCounts.get(discount[tail]) - 1);
                tail++;
            } while (true);
            return answer;
        }

    }

}
