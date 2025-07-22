public class PG_20250619_최소직사각형 {

    class Solution {

        public int solution(int[][] sizes) {
            int maxWidth = 0;
            int maxHeight = 0;
            for (int[] size : sizes) {
                if (size[0] < size[1]) {
                    if (maxWidth < size[1]) {
                        maxWidth = size[1];
                    }
                    if (maxHeight < size[0]) {
                        maxHeight = size[0];
                    }
                } else {
                    if (maxWidth < size[0]) {
                        maxWidth = size[0];
                    }
                    if (maxHeight < size[1]) {
                        maxHeight = size[1];
                    }
                }
            }
            return maxWidth * maxHeight;
        }

    }

}
