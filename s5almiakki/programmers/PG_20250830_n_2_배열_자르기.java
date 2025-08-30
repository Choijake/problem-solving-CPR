
public class PG_20250830_n_2_배열_자르기 {

    class Solution {

        public int[] solution(int n, long left, long right) {
            int[] result = new int[(int) (right - left) + 1];
            for (long i = left; i <= right; i++) {
                result[(int) (i - left)] = (int) Math.max(i / n, i % n) + 1;
            }
            return result;
        }

    }

}
