import java.util.*;

public class PG_20251021_리코쳇_로봇 {

    class Solution {

        private static final int[][] DIRECTIONS = {
                { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
        };

        public int solution(String[] board) {
            int[] startPoint = null;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length(); col++) {
                    if (board[row].charAt(col) == 'R') {
                        startPoint = new int[] { row, col, 0 };
                        break;
                    }
                }
                if (startPoint != null) {
                    break;
                }
            }
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[board.length][board[0].length()];
            queue.add(startPoint);
            visited[startPoint[0]][startPoint[1]] = true;
            do {
                int[] currentPoint = queue.remove();
                for (int[] direction : DIRECTIONS) {
                    int newRow = currentPoint[0];
                    int newCol = currentPoint[1];
                    int newMovementCnt = currentPoint[2];
                    while (canGo(board, newRow + direction[0], newCol + direction[1])) {
                        newRow += direction[0];
                        newCol += direction[1];
                    }
                    newMovementCnt++;
                    if (board[newRow].charAt(newCol) == 'G') {
                        return newMovementCnt;
                    }
                    if (visited[newRow][newCol]) {
                        continue;
                    }
                    queue.add(new int[] { newRow, newCol, newMovementCnt });
                    visited[newRow][newCol] = true;
                }
            } while (!queue.isEmpty());
            return -1;
        }

        private boolean canGo(String[] board, int row, int col) {
            return !isOutOfBounds(board, row, col)
                    && board[row].charAt(col) != 'D';
        }

        private boolean isOutOfBounds(String[] board, int row, int col) {
            return row < 0 || board.length <= row
                    || col < 0 || board[0].length() <= col;
        }

    }

}
