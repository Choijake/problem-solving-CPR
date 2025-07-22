import java.util.*;

public class PG_20250701_순위 {

    class Solution {

        public int solution(int n, int[][] results) {
            List<List<Integer>> victoryList = new ArrayList<>();
            List<List<Integer>> defeatList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                victoryList.add(new ArrayList<>());
                defeatList.add(new ArrayList<>());
            }
            for (int[] result : results) {
                int winner = result[0] - 1;
                int loser = result[1] - 1;
                victoryList.get(winner).add(loser);
                defeatList.get(loser).add(winner);
            }
            int result = 0;
            for (int player = 0; player < n; player++) {
                int winnerCnt = bfs(n, player, victoryList);
                int loserCnt = bfs(n, player, defeatList);
                if (winnerCnt + loserCnt == n - 1) {
                    result++;
                }
            }
            return result;
        }

        private int bfs(int playerCnt, int startPlayer, List<List<Integer>> list) {
            boolean[] visited = new boolean[playerCnt];
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(startPlayer);
            visited[startPlayer] = true;
            int result = 0;
            do {
                int currentPlayer = queue.remove();
                for (int adjPlayer : list.get(currentPlayer)) {
                    if (visited[adjPlayer]) {
                        continue;
                    }
                    queue.add(adjPlayer);
                    visited[adjPlayer] = true;
                    result++;
                }
            } while (!queue.isEmpty());
            return result;
        }

    }

}
