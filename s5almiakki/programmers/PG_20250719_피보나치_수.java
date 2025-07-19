
public class PG_20250719_피보나치_수 {

    class Solution {

        public int solution(int n) {
            int[] fibonacci = new int[n + 1];
            fibonacci[0] = 0;
            if (n > 1) {
                fibonacci[1] = 1;
            }
            for (int i = 2; i <= n; i++) {
                fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % 1234567;
            }
            return fibonacci[n];
        }

    }

}
