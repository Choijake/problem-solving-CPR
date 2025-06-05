import java.util.*;

public class PG_20250605_게임_맵_최단거리 {

    class Solution {

        private int[] dRow = { 0, 0, -1, 1 };
        private int[] dCol = { -1, 1, 0, 0 };

        private int[][] maps;
        private boolean[][] visited;

        public int solution(int[][] maps) {
            this.maps = maps;
            this.visited = new boolean[maps.length][maps[0].length];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] { 0, 0, 1 }); // row, col, cnt
            visited[0][0] = true;
            while (true) {
                if (queue.isEmpty()) {
                    return -1;
                }
                int[] current = queue.remove();
                if (current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                    return current[2];
                }
                for (int direction = 0; direction < 4; direction++) {
                    int newRow = current[0] + dRow[direction];
                    int newCol = current[1] + dCol[direction];
                    if (!isVisitable(newRow, newCol)) {
                        continue;
                    }
                    queue.add(new int[] { newRow, newCol, current[2] + 1 });
                    visited[newRow][newCol] = true;
                }
            }
        }

        private boolean isVisitable(int row, int col) {
            return !isOutOfBounds(row, col)
                    && maps[row][col] == 1
                    && !visited[row][col];
        }

        private boolean isOutOfBounds(int row, int col) {
            return row < 0 || maps.length <= row
                    || col < 0 || maps[0].length <= col;
        }

    }

}
