import java.util.*;

public class PG_20250726_최고의_집합 {

    class Solution {

        public int[] solution(int n, int s) {
            if (n > s) {
                return new int[] { -1 };
            }
            int[] result = new int[n];
            int avg = s / n;
            Arrays.fill(result, avg);
            int remainder = s % n;
            for (int i = n - 1; i >= n - remainder; i--) {
                result[i]++;
            }
            return result;
        }

    }

}
