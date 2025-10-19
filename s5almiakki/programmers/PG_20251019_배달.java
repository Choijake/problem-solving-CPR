import java.util.*;

public class PG_20251019_배달 {

    class Solution {

        public int solution(int N, int[][] road, int K) {
            List<List<int[]>> adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] r : road) {
                r[0]--;
                r[1]--;
                adjList.get(r[0]).add(new int[] { r[1], r[2] });
                adjList.get(r[1]).add(new int[] { r[0], r[2] });
            }
            Queue<int[]> queue = new ArrayDeque<>();
            int[] distances = new int[N];
            Arrays.fill(distances, Integer.MAX_VALUE);
            queue.add(new int[] { 0, 0 });
            distances[0] = 0;
            do {
                int[] currentNodeDistance = queue.remove();
                for (int[] adjNodeDistance : adjList.get(currentNodeDistance[0])) {
                    int newDistance = currentNodeDistance[1] + adjNodeDistance[1];
                    if (distances[adjNodeDistance[0]] <= newDistance || K < newDistance) {
                        continue;
                    }
                    queue.add(new int[] { adjNodeDistance[0], newDistance });
                    distances[adjNodeDistance[0]] = newDistance;
                }
            } while (!queue.isEmpty());
            int answer = 0;
            for (int distance : distances) {
                if (distance <= K) {
                    answer++;
                }
            }
            return answer;
        }

    }

}
