import java.util.*;

public class PG_20251029_등대 {

    class Solution {

        private List<Set<Integer>> adjList = new ArrayList<>();
        private Set<Set<Integer>> brightEdges = new HashSet<>();

        private int answer = 0;

        public int solution(int n, int[][] lighthouse) {
            for (int i = 0; i < n; i++) {
                adjList.add(new HashSet<>());
            }
            for (int[] edge : lighthouse) {
                edge[0]--;
                edge[1]--;
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
            dfs(0, -1);
            return answer;
        }

        private void dfs(int currentNode, int parentNode) {
            boolean darkEdgePresent = false;
            for (int adjNode : adjList.get(currentNode)) {
                if (adjNode == parentNode) {
                    continue;
                }
                if (adjList.get(adjNode).size() == 1) {
                    darkEdgePresent = true;
                    continue;
                }
                dfs(adjNode, currentNode);
                if (!brightEdges.contains(Set.of(currentNode, adjNode))) {
                    darkEdgePresent = true;
                }
            }
            if (darkEdgePresent) {
                for (int adjNode : adjList.get(currentNode)) {
                    brightEdges.add(Set.of(currentNode, adjNode));
                }
                answer++;
                return;
            }
        }

    }

}
