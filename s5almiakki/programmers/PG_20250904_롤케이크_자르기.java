import java.util.*;

public class PG_20250904_롤케이크_자르기 {

    class Solution {

        public int solution(int[] topping) {
            Map<Integer, Integer> piece1 = new HashMap<>();
            Map<Integer, Integer> piece2 = new HashMap<>();
            for (int t : topping) {
                piece2.put(t, piece2.getOrDefault(t, 0) + 1);
            }
            int answer = 0;
            for (int t : topping) {
                piece1.put(t, piece1.getOrDefault(t, 0) + 1);
                piece2.put(t, piece2.get(t) - 1);
                if (piece2.get(t).equals(0)) {
                    piece2.remove(t);
                }
                if (piece1.size() == piece2.size()) {
                    answer++;
                }
            }
            return answer;
        }

    }

}
