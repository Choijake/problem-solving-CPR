
public class PG_20251028_평균_구하기 {

    class Solution {

        public double solution(int[] arr) {
            double answer = 0;
            for (int i : arr) {
                answer += i;
            }
            return answer / (double) arr.length;
        }

    }

}
