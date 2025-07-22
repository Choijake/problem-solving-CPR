import java.util.*;

public class PG_20250628_더_맵게 {

    class Solution {

        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.add(s);
            }
            int result = 0;
            while (true) {
                int lowestScoville = pq.remove();
                if (lowestScoville >= K) {
                    break;
                }
                if (pq.isEmpty()) {
                    return -1;
                }
                int secondScoville = pq.remove();
                int newScoville = lowestScoville + (secondScoville << 1);
                pq.add(newScoville);
                result++;
            }
            return result;
        }

    }

}
