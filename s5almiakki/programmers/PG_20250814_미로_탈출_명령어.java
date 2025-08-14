
public class PG_20250814_미로_탈출_명령어 {

    class Solution {

        private int rowCnt;
        private int colCnt;
        private int targetRow;
        private int targetCol;
        private int targetMovementCnt;
        private StringBuilder answer = new StringBuilder();

        private void init(int n, int m, int r, int c, int k) {
            this.rowCnt = n;
            this.colCnt = m;
            this.targetRow = r;
            this.targetCol = c;
            this.targetMovementCnt = k;
        }

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            init(n, m, r, c, k);
            int distance = Math.abs(targetRow - x) + Math.abs(targetCol - y);
            if ((targetMovementCnt - distance) % 2 == 1) {
                return "impossible";
            }
            return dfs(x, y) ? answer.toString() : "impossible";
        }

        private boolean dfs(int currentRow, int currentCol) {
            int remainingMovementCnt = targetMovementCnt - answer.length();
            if (remainingMovementCnt == 0) {
                return currentRow == targetRow && currentCol == targetCol;
            }
            int distance = Math.abs(targetRow - currentRow) + Math.abs(targetCol - currentCol);
            if (remainingMovementCnt < distance) {
                return false;
            }
            for (Direction direction : Direction.values()) {
                int newRow = currentRow + direction.dRow;
                int newCol = currentCol + direction.dCol;
                if (isOutOfBounds(newRow, newCol)) {
                    continue;
                }
                answer.append(direction.letter);
                if (dfs(newRow, newCol)) {
                    return true;
                }
                answer.deleteCharAt(answer.length() - 1);
            }
            return false;
        }

        private boolean isOutOfBounds(int row, int col) {
            return row <= 0 || rowCnt < row
                    || col <= 0 || colCnt < col;
        }

        private static enum Direction {

            DOWN(1, 0, 'd'),
            LEFT(0, -1, 'l'),
            RIGHT(0, 1, 'r'),
            UP(-1, 0, 'u');

            public final int dRow;
            public final int dCol;
            public final char letter;

            Direction(int dRow, int dCol, char letter) {
                this.dRow = dRow;
                this.dCol = dCol;
                this.letter = letter;
            }

        }

    }

}
