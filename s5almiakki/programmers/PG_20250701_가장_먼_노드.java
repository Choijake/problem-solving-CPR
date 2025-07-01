import java.util.*;

public class PG_20250701_가장_먼_노드 {

    class Solution {

        public int solution(int n, int[][] edge) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] e : edge) {
                adjList.get(e[0]).add(e[1]);
                adjList.get(e[1]).add(e[0]);
            }
            boolean[] visited = new boolean[n + 1];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] { 1, 0 });
            visited[1] = true;
            List<int[]> nodes = new ArrayList<>();
            int maxDistance = 0;
            do {
                int[] currentNode = queue.remove();
                nodes.add(currentNode);
                if (maxDistance < currentNode[1]) {
                    maxDistance = currentNode[1];
                }
                int newDistance = currentNode[1] + 1;
                for (int adjNode : adjList.get(currentNode[0])) {
                    if (visited[adjNode]) {
                        continue;
                    }
                    queue.add(new int[] { adjNode, newDistance });
                    visited[adjNode] = true;
                }
            } while (!queue.isEmpty());
            int result = 0;
            for (int[] node : nodes) {
                if (node[1] == maxDistance) {
                    result++;
                }
            }
            return result;
        }

    }

}
