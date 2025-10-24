
public class PG_20251024_자릿수_더하기 {

    public class Solution1 {

        public int solution(int n) {
            int answer = 0;
            for (char c : String.valueOf(n).toCharArray()) {
                answer += c - '0';
            }
            return answer;
        }

    }

    public class Solution2 {

        public int solution(int n) {
            int answer = 0;
            while (n > 0) {
                answer += n % 10;
                n /= 10;
            }
            return answer;
        }

    }

}
