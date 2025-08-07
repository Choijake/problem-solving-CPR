
public class PG_20250807_파괴되지_않은_건물 {

    class Solution {

        public int solution(int[][] board, int[][] skill) {
            int[][] deltas = new int[board.length][board[0].length];
            for (int[] command : skill) {
                int r1 = command[1];
                int c1 = command[2];
                int r2 = command[3] + 1;
                int c2 = command[4] + 1;
                int degree;
                if (command[0] == 1) {
                    degree = -command[5];
                } else {
                    degree = command[5];
                }
                deltas[r1][c1] += degree;
                if (r2 < deltas.length) {
                    deltas[r2][c1] -= degree;
                    if (c2 < deltas[r2].length) {
                        deltas[r2][c2] += degree;
                    }
                }
                if (c2 < deltas[r1].length) {
                    deltas[r1][c2] -= degree;
                }
            }
            for (int row = 0; row < deltas.length; row++) {
                for (int col = 1; col < deltas[row].length; col++) {
                    deltas[row][col] += deltas[row][col - 1];
                }
            }
            for (int row = 1; row < deltas.length; row++) {
                for (int col = 0; col < deltas[row].length; col++) {
                    deltas[row][col] += deltas[row - 1][col];
                }
            }
            int answer = 0;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col] + deltas[row][col] > 0) {
                        answer++;
                    }
                }
            }
            return answer;
        }

    }

}
