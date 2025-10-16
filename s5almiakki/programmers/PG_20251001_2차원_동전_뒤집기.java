import java.util.*;

public class PG_20251001_2차원_동전_뒤집기 {

    class Solution {

        public int solution(int[][] beginning, int[][] target) {
            int[][] board = new int[beginning.length][];
            for (int row = 0; row < board.length; row++) {
                board[row] = Arrays.copyOf(beginning[row], beginning[row].length);
            }
            int answer = 0;
            int[] rowDiffCnts = new int[board.length];
            int[] colDiffCnts = new int[board[0].length];
            while (!isEqual(board, target)) {
                computeDiffCnts(rowDiffCnts, colDiffCnts, board, target);
                int maxAxis = 0;
                int maxIdx = -1;
                int maxDiffCnt = 0;
                for (int i = 0; i < board.length; i++) {
                    if (maxDiffCnt < rowDiffCnts[i]) {
                        maxIdx = i;
                        maxDiffCnt = rowDiffCnts[i];
                    }
                }
                for (int i = 0; i < board[0].length; i++) {
                    if (maxDiffCnt < colDiffCnts[i]) {
                        maxAxis = 1;
                        maxIdx = i;
                        maxDiffCnt = colDiffCnts[i];
                    }
                }
                if (maxAxis == 0) {
                    for (int i = 0; i < board[0].length; i++) {
                        board[maxIdx][i] = (board[maxIdx][i] + 1) % 2;
                    }
                } else {
                    for (int i = 0; i < board.length; i++) {
                        board[i][maxIdx] = (board[i][maxIdx] + 1) % 2;
                    }
                }
                answer++;
                if (answer > board.length * board[0].length) {
                    answer = -1;
                    break;
                }
            }
            return answer;
        }

        private boolean isEqual(int[][] board, int[][] target) {
            for (int row = 0; row < board.length; row++) {
                if (!Arrays.equals(board[row], target[row])) {
                    return false;
                }
            }
            return true;
        }

        private void computeDiffCnts(int[] rowDiffCnts, int[] colDiffCnts, int[][] board, int[][] target) {
            Arrays.fill(rowDiffCnts, 0);
            Arrays.fill(colDiffCnts, 0);
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col] != target[row][col]) {
                        rowDiffCnts[row]++;
                        colDiffCnts[col]++;
                    }
                }
            }
        }

    }

}
