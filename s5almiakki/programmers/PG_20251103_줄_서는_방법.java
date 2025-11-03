import java.util.*;

public class PG_20251103_줄_서는_방법 {

    class Solution {

        private final long[] factorials = new long[21];

        {
            factorials[0] = 1L;
            for (int i = 1; i < factorials.length; i++) {
                factorials[i] = i * factorials[i - 1];
            }
        }

        public int[] solution(int n, long k) {
            k--;
            List<Integer> people = new LinkedList<>();
            for (int person = 1; person <= n; person++) {
                people.add(person);
            }
            int[] answer = new int[n];
            for (int answerIdx = 0; answerIdx < n; answerIdx++) {
                long factorial = factorials[n - answerIdx - 1];
                int personIdx = 0;
                while (k - factorial >= 0) {
                    k -= factorial;
                    personIdx++;
                }
                answer[answerIdx] = people.get(personIdx);
                people.remove(personIdx);
            }
            return answer;
        }

    }

}
