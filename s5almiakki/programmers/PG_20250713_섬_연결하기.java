import java.util.*;

public class PG_20250713_섬_연결하기 {

    class Solution {

        public int solution(int n, int[][] costs) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
            int answer = 0;
            for (int[] cost : costs) {
                if (formsCycle(adjList, cost)) {
                    continue;
                }
                adjList.get(cost[0]).add(cost[1]);
                adjList.get(cost[1]).add(cost[0]);
                answer += cost[2];
            }
            return answer;
        }

        private boolean formsCycle(List<List<Integer>> adjList, int[] cost) {
            boolean[] visited = new boolean[adjList.size()];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(cost[0]);
            visited[cost[0]] = true;
            do {
                int currentNode = queue.remove();
                for (Integer adjNode : adjList.get(currentNode)) {
                    if (adjNode.equals(cost[1])) {
                        return true;
                    }
                    if (visited[adjNode]) {
                        continue;
                    }
                    queue.add(adjNode);
                    visited[adjNode] = true;
                }
            } while (!queue.isEmpty());
            return false;
        }

    }

}
