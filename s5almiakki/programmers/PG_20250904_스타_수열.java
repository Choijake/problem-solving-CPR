
public class PG_20250904_스타_수열 {

    class Solution {

        public int solution(int[] a) {
            if (a.length == 1) {
                return 0;
            }
            int[] counts = new int[a.length];
            for (int element : a) {
                counts[element]++;
            }
            int answer = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] <= answer) {
                    continue;
                }
                int count = 0;
                for (int j = 1; j < a.length; j++) {
                    if ((a[j - 1] == i || a[j] == i) && a[j - 1] != a[j]) {
                        count++;
                        j++;
                    }
                }
                answer = Math.max(answer, count);
            }
            return answer << 1;
        }

    }

}
