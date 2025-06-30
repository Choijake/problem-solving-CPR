import java.util.*;

public class PG_20250603_네트워크 {

    class Solution {

        private boolean[] visited;
        private int computerCnt;
        private int[][] computers;

        public int solution(int n, int[][] computers) {
            this.visited = new boolean[n];
            this.computerCnt = n;
            this.computers = computers;
            int networkCnt = 0;
            for (int startComputer = 0; startComputer < n; startComputer++) {
                if (visited[startComputer]) {
                    continue;
                }
                bfs(startComputer);
                networkCnt++;
            }
            return networkCnt;
        }

        private void bfs(int startComputer) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(startComputer);
            visited[startComputer] = true;
            while (!queue.isEmpty()) {
                int currentComputer = queue.remove();
                visited[currentComputer] = true;
                for (int newComputer = 0; newComputer < computerCnt; newComputer++) {
                    if (!visited[newComputer] && computers[currentComputer][newComputer] == 1) {
                        queue.add(newComputer);
                    }
                }
            }
        }
    }
}
