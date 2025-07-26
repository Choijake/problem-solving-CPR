import java.util.*;

public class PG_20250726_숫자_게임 {

    class Solution {

        public int solution(int[] A, int[] B) {
            Arrays.sort(A);
            Arrays.sort(B);
            int highestIdx = B.length - 1;
            int result = 0;
            for (int i = A.length - 1; i >= 0; i--) {
                if (A[i] < B[highestIdx]) {
                    highestIdx--;
                    result++;
                }
            }
            return result;
        }

    }

}
