import java.util.*;

public class PG_20250718_최솟값_만들기 {

    class Solution {

        public int solution(int []A, int []B) {
            Arrays.sort(A);
            Arrays.sort(B);
            int answer = 0;
            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[B.length - 1 - i];
            }
            return answer;
        }

    }

}
