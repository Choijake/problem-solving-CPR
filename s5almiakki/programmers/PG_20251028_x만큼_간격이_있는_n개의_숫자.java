
public class PG_20251028_x만큼_간격이_있는_n개의_숫자 {

    class Solution {

        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            long element = x;
            for (int i = 0; i < answer.length; i++) {
                answer[i] = element;
                element += x;
            }
            return answer;
        }

    }

}
