
public class PG_20250718_최댓값과_최솟값 {

    class Solution {

        public String solution(String s) {
            String[] input = s.split(" ");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (String n : input) {
                int i = Integer.parseInt(n);
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
            return min + " " + max;
        }

    }

}
