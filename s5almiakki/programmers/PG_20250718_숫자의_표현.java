
public class PG_20250718_숫자의_표현 {

    class Solution {

        public int solution(int n) {
            int hi = 1;
            int lo = 1;
            int sum = 1;
            int answer = 0;
            do {
                if (sum > n) {
                    sum -= lo;
                    lo++;
                    continue;
                }
                if (sum == n) {
                    answer++;
                }
                hi++;
                sum += hi;
                continue;
            } while (hi <= n);
            return answer;
        }

    }

}
