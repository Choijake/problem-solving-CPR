import java.util.*;

public class PG_20250712_구명보트 {

    class Solution {

        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int minWeightIdx = 0;
            int maxWeightIdx = people.length - 1;
            int answer = 0;
            do {
                int minWeight = people[minWeightIdx];
                int maxWeight = people[maxWeightIdx];
                if (minWeight + maxWeight <= limit) {
                    minWeightIdx++;
                }
                maxWeightIdx--;
                answer++;
            } while (minWeightIdx <= maxWeightIdx);
            return answer;
        }

    }

}
