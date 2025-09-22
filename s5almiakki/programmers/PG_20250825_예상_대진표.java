
public class PG_20250825_예상_대진표 {

    class Solution {

        public int solution(int n, int a, int b) {
            int answer = 1;
            do {
                if (a % 2 == 0) {
                    a--;
                }
                if (b % 2 == 0) {
                    b--;
                }
                if (a == b) {
                    break;
                }
                a = (a >> 1) + 1;
                b = (b >> 1) + 1;
                answer++;
            } while (true);
            return answer;
        }

    }

}
