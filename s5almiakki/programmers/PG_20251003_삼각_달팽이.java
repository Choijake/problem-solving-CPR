
public class PG_20251003_삼각_달팽이 {

    class Solution {

        private int[][] directions = {
                { 1, 0 }, { 0, 1 }, { -1, -1 }
        };

        public int[] solution(int n) {
            int[][] snail = new int[n][n];
            int row = -1;
            int col = 0;
            int directionIdx = 0;
            int value = 1;
            int answerLength = 0;
            for (int length = n; length >= 1; length--) {
                answerLength += length;
                for (int i = 0; i < length; i++) {
                    row += directions[directionIdx][0];
                    col += directions[directionIdx][1];
                    snail[row][col] = value;
                    value++;
                }
                directionIdx = (directionIdx + 1) % 3;
            }
            int[] answer = new int[answerLength];
            row = 0;
            col = 0;
            for (int i = 0; i < answer.length; i++) {
                answer[i] = snail[row][col];
                col++;
                if (col < snail[row].length && snail[row][col] == 0) {
                    row++;
                    col = 0;
                }
            }
            return answer;
        }

    }

}
