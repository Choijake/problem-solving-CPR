import java.util.*;

public class PG_20250926_1차_프렌즈4블록 {

    class Solution {

        private static char EMPTY_BLOCK = (char) 0;
        private static int[][] directions = {
                { -1, -1 }, { -1, 0 }, { 0, -1 }, { 0, 0 }
        };

        private char[][] table;

        public int solution(int m, int n, String[] board) {
            init(m, n, board);
            int answer = 0;
            do {
                int[] firstErasableBlockPoint = computeFirstErasableBlockPoint();
                if (firstErasableBlockPoint == null) {
                    break;
                }
                answer += eraseBlocks(firstErasableBlockPoint[0], firstErasableBlockPoint[1]);
                dropBlocks();
            } while (true);
            return answer;
        }

        private void init(int m, int n, String[] board) {
            table = new char[board.length][];
            for (int i = 0; i < table.length; i++) {
                table[i] = board[i].toCharArray();
            }
        }

        private int[] computeFirstErasableBlockPoint() {
            for (int row = 1; row < table.length; row++) {
                for (int col = 1; col < table[row].length; col++) {
                    if (table[row][col] == EMPTY_BLOCK) {
                        continue;
                    }
                    if (canErase(row, col)) {
                        return new int[] { row, col };
                    }
                }
            }
            return null;
        }

        private boolean canErase(int row, int col) {
            if (table[row][col] == (char) 0) {
                return false;
            }
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (table[newRow][newCol] == EMPTY_BLOCK || table[row][col] != table[newRow][newCol]) {
                    return false;
                }
            }
            return true;
        }

        private int eraseBlocks(int startRow, int startCol) {
            boolean[][] erased = new boolean[table.length][table[0].length];
            // 인자 좌표의 블럭 4개는 지울 수 있음이 보장되므로 건너뜀
            for (int[] direction : directions) {
                erased[startRow + direction[0]][startCol + direction[1]] = true;
            }
            for (int col = startCol + 1; col < table[0].length; col++) {
                if (!canErase(startRow, col)) {
                    continue;
                }
                for (int[] direction : directions) {
                    erased[startRow + direction[0]][col + direction[1]] = true;
                }
            }
            for (int row = startRow + 1; row < table.length; row++) {
                for (int col = 1; col < table[row].length; col++) {
                    if (!canErase(row, col)) {
                        continue;
                    }
                    for (int[] direction : directions) {
                        erased[row + direction[0]][col + direction[1]] = true;
                    }
                }
            }
            int totalErasureCnt = 0;
            for (int row = 0; row < table.length; row++) {
                for (int col = 0; col < table[row].length; col++) {
                    if (erased[row][col]) {
                        table[row][col] = EMPTY_BLOCK;
                        totalErasureCnt++;
                    }
                }
            }
            return totalErasureCnt;
        }

        private void dropBlocks() {
            Queue<Character> queue = new ArrayDeque<>();
            for (int col = 0; col < table[0].length; col++) {
                for (int row = table.length - 1; row >= 0; row--) {
                    if (table[row][col] != EMPTY_BLOCK) {
                        queue.add(table[row][col]);
                    }
                }
                int targetRow = table.length - 1;
                while (!queue.isEmpty()) {
                    table[targetRow][col] = queue.remove();
                    targetRow--;
                }
                for (int row = 0; row <= targetRow; row++) {
                    table[row][col] = EMPTY_BLOCK;
                }
            }
        }

    }

}
