import java.util.*;

public class PG_20250714_단속카메라 {

    class Solution {

        public int solution(int[][] routes) {
            Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
            int answer = 0;
            int min = -30_000;
            for (int[] route : routes) {
                if (route[0] <= min && min <= route[1]) {
                    continue;
                }
                answer++;
                min = route[1];
            }
            return answer;
        }

    }

}
