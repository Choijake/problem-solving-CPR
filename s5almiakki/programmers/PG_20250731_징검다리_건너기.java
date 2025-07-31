
public class PG_20250731_징검다리_건너기 {

    class Solution {

        public int solution(int[] stones, int k) {
            int hi = 200_000_000;
            int lo = 1;
            int answer = 0;
            int[] stonesCopy = new int[stones.length];
            do {
                int mid = (hi + lo) >> 1;
                for (int i = 0; i < stones.length; i++) {
                    stonesCopy[i] = stones[i] - mid;
                }
                int successive0Cnt = 0;
                for (int stone : stonesCopy) {
                    if (stone > 0) {
                        successive0Cnt = 0;
                        continue;
                    }
                    successive0Cnt++;
                    if (successive0Cnt == k) {
                        break;
                    }
                }
                if (successive0Cnt < k) {
                    answer = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } while (lo <= hi);
            return answer + 1;
        }

    }

}
