
public class PG_20250706_정수_삼각형 {

    class Solution {

        public int solution(int[][] triangle) {
            int[][] sums = new int[triangle.length][];
            sums[0] = new int[] { triangle[0][0] };
            for (int i = 1; i < triangle.length; i++) {
                sums[i] = new int[triangle[i].length];
                sums[i][0] = sums[i - 1][0] + triangle[i][0];
                for (int j = 1; j < triangle[i].length - 1; j++) {
                    sums[i][j] = Math.max(sums[i - 1][j - 1], sums[i - 1][j])
                            + triangle[i][j];
                }
                sums[i][triangle[i].length - 1] = sums[i - 1][triangle[i - 1].length - 1]
                        + triangle[i][triangle[i].length - 1];
            }
            int result = 0;
            for (int sum : sums[sums.length - 1]) {
                if (result < sum) {
                    result = sum;
                }
            }
            return result;
        }

    }

}
