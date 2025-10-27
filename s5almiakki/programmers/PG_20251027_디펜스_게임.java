import java.util.*;

public class PG_20251027_디펜스_게임 {

    class Solution {

        public int solution(int n, int k, int[] enemy) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int round = 0; round < enemy.length; round++) {
                n -= enemy[round];
                pq.add(enemy[round]);
                while (n < 0 && k > 0) {
                    n += pq.remove();
                    k--;
                }
                if (n < 0 && k == 0) {
                    return round;
                }
            }
            return enemy.length;
        }

    }

}
