
public class PG_20250805_풍선_터뜨리기 {

    class Solution {

        public int solution(int[] a) {
            if (a.length <= 2) {
                return a.length;
            }
            // [0]: 작은 풍선을 터뜨린 적 없는 경우, [1]: 있는 경우
            int[][] dpFromLeft = new int[2][a.length];
            int[][] dpFromRight = new int[2][a.length];
            dpFromLeft[0][0] = a[0];
            dpFromLeft[1][0] = a[0];
            dpFromRight[0][a.length - 1] = a[a.length - 1];
            dpFromRight[1][a.length - 1] = a[a.length - 1];
            for (int leftIdx = 1; leftIdx < a.length; leftIdx++) {
                int rightIdx = a.length - 1 - leftIdx;
                dpFromLeft[0][leftIdx] = Math.min(dpFromLeft[0][leftIdx - 1], a[leftIdx]);
                dpFromLeft[1][leftIdx] = Math.max(
                        dpFromLeft[1][leftIdx - 1],
                        Math.max(dpFromLeft[0][leftIdx - 1], a[leftIdx]));
                dpFromRight[0][rightIdx] = Math.min(dpFromRight[0][rightIdx + 1], a[rightIdx]);
                dpFromRight[1][rightIdx] = Math.max(
                        dpFromRight[1][rightIdx + 1],
                        Math.max(dpFromRight[0][rightIdx + 1], a[rightIdx]));
            }
            int answer = 2;
            for (int i = 1; i < a.length - 1; i++) {
                if (dpFromLeft[0][i - 1] < a[i] && a[i] > dpFromRight[0][i + 1]) {
                    continue;
                }
                answer++;
            }
            return answer;
        }

    }

}
