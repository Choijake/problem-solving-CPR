
public class PG_20250927_쿼드압축_후_개수_세기 {

    class Solution {

        private int[] answer = new int[2];

        private int[][] arr;

        public int[] solution(int[][] arr) {
            this.arr = arr;
            compress(0, 0, arr.length, arr.length);
            return answer;
        }

        private void compress(int lowRow, int lowCol, int highRow, int highCol) {
            if (canCompress(lowRow, lowCol, highRow, highCol)) {
                answer[arr[lowRow][lowCol]]++;
                return;
            }
            int midRow = (lowRow + highRow) >> 1;
            int midCol = (lowCol + highCol) >> 1;
            // left top
            compress(lowRow, lowCol, midRow, midCol);
            // right top
            compress(lowRow, midCol, midRow, highCol);
            // left bottom
            compress(midRow, lowCol, highRow, midCol);
            // right bottom
            compress(midRow, midCol, highRow, highCol);
        }

        private boolean canCompress(int lowRow, int lowCol, int highRow, int highCol) {
            int base = arr[lowRow][lowCol];
            for (int row = lowRow; row < highRow; row++) {
                for (int col = lowCol; col < highCol; col++) {
                    if (base != arr[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }

    }

}
