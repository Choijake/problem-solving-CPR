import java.util.*;

public class PG_20251017_미로_탈출 {

    class Solution {

        private static final int[] D_ROW = { -1, 1, 0, 0 };
        private static final int[] D_COL = { 0, 0, -1, 1 };

        public int solution(String[] maps) {
            int[] startPoint = new int[3];
            for (int row = 0; row < maps.length; row++) {
                boolean startPointFound = false;
                for (int col = 0; col < maps[row].length(); col++) {
                    if (maps[row].charAt(col) == 'S') {
                        startPoint[0] = row;
                        startPoint[1] = col;
                        startPointFound = true;
                        break;
                    }
                }
                if (startPointFound) {
                    break;
                }
            }
            int[] targetPoint = bfs(maps, startPoint, 'L');
            if (targetPoint[2] == -1) {
                return -1;
            }
            targetPoint = bfs(maps, targetPoint, 'E');
            if (targetPoint[2] == -1) {
                return -1;
            }
            return targetPoint[2];
        }

        private int[] bfs(String[] map, int[] startPoint, char target) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[map.length][map[0].length()];
            queue.add(startPoint);
            visited[startPoint[0]][startPoint[1]] = true;
            do {
                int[] currentPoint = queue.remove();
                for (int direction = 0; direction < 4; direction++) {
                    int newRow = currentPoint[0] + D_ROW[direction];
                    int newCol = currentPoint[1] + D_COL[direction];
                    if (!canVisit(map, newRow, newCol)
                            || visited[newRow][newCol]) {
                        continue;
                    }
                    int newDistance = currentPoint[2] + 1;
                    if (map[newRow].charAt(newCol) == target) {
                        return new int[] { newRow, newCol, newDistance };
                    }
                    queue.add(new int[] { newRow, newCol, newDistance });
                    visited[newRow][newCol] = true;
                }
            } while (!queue.isEmpty());
            return new int[] { -1, -1, -1 };
        }

        private boolean canVisit(String[] map, int row, int col) {
            return !isOutOfBounds(map, row, col)
                    && map[row].charAt(col) != 'X';
        }

        private boolean isOutOfBounds(String[] map, int row, int col) {
            return row < 0 || map.length <= row
                    || col < 0 || map[row].length() <= col;
        }

    }

}
