import java.util.*;

public class PG_20250623_전력망을_둘로_나누기 {

    class Solution {

        public int solution(int n, int[][] wires) {
            boolean[][] adjMat = new boolean[n][n];
            for (int[] wire : wires) {
                wire[0]--;
                wire[1]--;
                connect(adjMat, wire[0], wire[1]);
            }
            int answer = Integer.MAX_VALUE;
            for (int[] wire : wires) {
                disconnect(adjMat, wire[0], wire[1]);
                int towerCnt1 = countTowerFrom(adjMat, wire[0]);
                int towerCnt2 = countTowerFrom(adjMat, wire[1]);
                int towerCntDiff = Math.abs(towerCnt1 - towerCnt2);
                if (towerCntDiff < answer) {
                    answer = towerCntDiff;
                }
                connect(adjMat, wire[0], wire[1]);
            }
            return answer;
        }

        private void connect(boolean[][] adjMat, int tower1, int tower2) {
            adjMat[tower1][tower2] = true;
            adjMat[tower2][tower1] = true;
        }

        private void disconnect(boolean[][] adjMat, int tower1, int tower2) {
            adjMat[tower1][tower2] = false;
            adjMat[tower2][tower1] = false;
        }

        private int countTowerFrom(boolean[][] adjMat, int beginTower) {
            int towerCnt = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[adjMat.length];
            queue.add(beginTower);
            visited[beginTower] = true;
            while (!queue.isEmpty()) {
                int currentTower = queue.remove();
                towerCnt++;
                for (int adjTower = 0; adjTower < adjMat[currentTower].length; adjTower++) {
                    if (!adjMat[currentTower][adjTower]) {
                        continue;
                    }
                    if (visited[adjTower]) {
                        continue;
                    }
                    queue.add(adjTower);
                    visited[adjTower] = true;
                }
            }
            return towerCnt;
        }

    }

}
