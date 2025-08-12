import java.util.*;

public class PG_20250812_양과_늑대 {

    class Solution {

        private int sheepCnt = 1;
        private int wolfCnt = 0;
        private int[] info;
        private List<List<Integer>> totalAdjList = new ArrayList<>();
        private int answer = 1;

        private void init(int[] info, int[][] edges) {
            this.info = info;
            for (int i = 0; i < info.length; i++) {
                totalAdjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                totalAdjList.get(edge[0]).add(edge[1]);
            }
        }

        public int solution(int[] info, int[][] edges) {
            init(info, edges);
            dfs(0, new HashSet<>(totalAdjList.get(0)));
            return answer;
        }

        private void dfs(int currentNode, Set<Integer> adjNodes) {
            if (answer < sheepCnt) {
                answer = sheepCnt;
            }
            for (int adjNode : adjNodes) {
                Set<Integer> newAdjNodes = new HashSet<>(adjNodes);
                newAdjNodes.addAll(totalAdjList.get(adjNode));
                newAdjNodes.remove(adjNode);
                if (info[adjNode] == 0) {
                    sheepCnt++;
                    dfs(adjNode, new HashSet<>(newAdjNodes));
                    sheepCnt--;
                    continue;
                }
                if (sheepCnt - wolfCnt <= 1) {
                    continue;
                }
                wolfCnt++;
                dfs(adjNode, new HashSet<>(newAdjNodes));
                wolfCnt--;
            }
        }

    }

}
