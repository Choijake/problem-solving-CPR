public class PG_20250618_최소직사각형 {

    class Solution {

        public int solution(int[][] sizes) {
            int maxWidth = 0;
            int maxHeight = 0;
            for (int[] size : sizes) {
                if (size[0] < size[1]) {
                    size[0] = swap(size[1], size[1] = size[0]);
                }
                if (maxWidth < size[0]) {
                    maxWidth = size[0];
                }
                if (maxHeight < size[1]) {
                    maxHeight = size[1];
                }
            }
            return maxWidth * maxHeight;
        }

        private int swap(int a, int b) {
            return a;
        }

    }

}
