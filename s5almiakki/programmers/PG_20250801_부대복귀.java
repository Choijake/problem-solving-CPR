import java.util.*;

public class PG_20250801_부대복귀 {

    class Solution {

        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] road : roads) {
                road[0]--;
                road[1]--;
                adjList.get(road[0]).add(road[1]);
                adjList.get(road[1]).add(road[0]);
            }
            destination--;
            Queue<int[]> queue = new ArrayDeque<>(); // [0]: node, [1]: distance
            queue.add(new int[] { destination, 0 });
            int[] distances = new int[n];
            Arrays.fill(distances, -1);
            do {
                int[] currentNodeDistance = queue.remove();
                distances[currentNodeDistance[0]] = currentNodeDistance[1];
                for (int newNode : adjList.get(currentNodeDistance[0])) {
                    if (distances[newNode] != -1) {
                        continue;
                    }
                    int newDistance = currentNodeDistance[1] + 1;
                    queue.add(new int[] { newNode, newDistance });
                    distances[newNode] = newDistance;
                }
            } while (!queue.isEmpty());
            int[] result = new int[sources.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = distances[sources[i] - 1];
            }
            return result;
        }

    }

}
