
public class PG_20251031_억억단을_외우자 {

    class Solution {

        public int[] solution(int e, int[] starts) {
            int[] frequencies = new int[e + 1];
            for (int divisor1 = 1; divisor1 <= e; divisor1++) {
                for (int divisor2 = 1; divisor2 <= e / divisor1; divisor2++) {
                    frequencies[divisor1 * divisor2]++;
                }
            }
            int[] dp = new int[e + 1];
            dp[e] = e;
            for (int start = e - 1; start >= 1; start--) {
                if (frequencies[dp[start + 1]] <= frequencies[start]) {
                    dp[start] = start;
                } else {
                    dp[start] = dp[start + 1];
                }
            }
            int[] answer = new int[starts.length];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = dp[starts[i]];
            }
            return answer;
        }

    }

}
