import java.util.*;

public class PG_20251026_모두_0으로_만들기 {

    class Solution {

        private long[] nodeWeights;
        private List<List<Integer>> adjList;

        public long solution(int[] a, int[][] edges) {
            int weightSum = 0;
            for (int weight : a) {
                weightSum += weight;
            }
            if (weightSum != 0) {
                return -1L;
            }

            nodeWeights = new long[a.length];
            for (int i = 0; i < a.length; i++) {
                nodeWeights[i] = a[i];
            }
            adjList = new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[a.length];
            Deque<int[]> stack = new ArrayDeque<>(); // [0]: parent, [1]: currentNode
            queue.add(0);
            visited[0] = true;
            stack.push(new int[] { -1, 0 });
            do {
                int currentNode = queue.remove();
                for (Integer child : adjList.get(currentNode)) {
                    if (visited[child]) {
                        continue;
                    }
                    queue.add(child);
                    visited[child] = true;
                    stack.push(new int[] { currentNode, child });
                }
            } while (!queue.isEmpty());

            long answer = 0L;
            do {
                int[] nodes = stack.pop();
                int parentNode = nodes[0];
                int currentNode = nodes[1];
                if (parentNode == -1 || nodeWeights[currentNode] == 0) {
                    continue;
                }
                nodeWeights[parentNode] += nodeWeights[currentNode];
                answer += Math.abs(nodeWeights[currentNode]);
                nodeWeights[currentNode] = 0;
            } while (!stack.isEmpty());
            return answer;
        }

    }

}
