import java.util.*;

public class PG_20250529_폰켓몬 {

    class Solution1 {

        public int solution(int[] nums) {
            Set<Integer> kinds = new HashSet<>();
            for (int num : nums) {
                kinds.add(num);
            }
            return Math.min(nums.length / 2, kinds.size());
        }
    }

    class Solution2 {

        public int solution(int[] nums) {
            boolean[] kindPresents = new boolean[200_001];
            int kindCnt = 0;
            for (int num : nums) {
                if (kindPresents[num]) {
                    continue;
                }
                kindPresents[num] = true;
                kindCnt++;
            }
            return Math.min(nums.length / 2, kindCnt);
        }
    }
}