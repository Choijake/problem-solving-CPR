import java.util.*;

public class PG_20250722_야근_지수 {

    class Solution {

        public long solution(int n, int[] works) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int work : works) {
                pq.add(work);
            }
            for (int i = 0; i < n; i++) {
                int work = pq.remove();
                if (work == 0) {
                    break;
                }
                pq.add(work - 1);
            }
            long answer = 0;
            do {
                int work = pq.remove();
                answer += work * work;
            } while (!pq.isEmpty());
            return answer;
        }

    }

}
