import java.util.*;

public class PG_20250929_두_큐_합_같게_만들기 {

    class Solution {

        public int solution(int[] queue1, int[] queue2) {
            int maxCnt = queue1.length << 2;
            Queue<Integer> q1 = new ArrayDeque<>();
            Queue<Integer> q2 = new ArrayDeque<>();
            long sum1 = 0;
            for (int i : queue1) {
                q1.add(i);
                sum1 += i;
            }
            long sum2 = 0;
            for (int i : queue2) {
                q2.add(i);
                sum2 += i;
            }
            int answer = 0;
            do {
                if (sum1 == sum2) {
                    break;
                }
                if (sum1 < sum2) {
                    if (q2.isEmpty()) {
                        answer = -1;
                        break;
                    }
                    Integer i = q2.remove();
                    sum2 -= i;
                    q1.add(i);
                    sum1 += i;
                } else {
                    if (q1.isEmpty()) {
                        answer = -1;
                        break;
                    }
                    Integer i = q1.remove();
                    sum1 -= i;
                    q2.add(i);
                    sum2 += i;
                }
                answer++;
                if (answer > maxCnt) {
                    answer = -1;
                    break;
                }
            } while (true);
            return answer;
        }

    }

}
