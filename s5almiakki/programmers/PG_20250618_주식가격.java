import java.util.*;

public class PG_20250618_주식가격 {

    class Solution1 {

        public int[] solution(int[] prices) {
            List<Integer> result = new ArrayList<>();
            for (int base = 0; base < prices.length; base++) {
                for (int offset = 0; base + offset < prices.length; offset++) {
                    if (prices[base] > prices[base + offset] || base + offset == prices.length - 1) {
                        result.add(offset);
                        break;
                    }
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }

    }

    class Solution2 {

        public int[] solution(int[] prices) {
            int[] result = new int[prices.length];
            int resultIdx = 0;
            for (int base = 0; base < prices.length; base++) {
                for (int offset = 0; base + offset < prices.length; offset++) {
                    if (prices[base] > prices[base + offset] || base + offset == prices.length - 1) {
                        result[resultIdx] = offset;
                        resultIdx++;
                        break;
                    }
                }
            }
            return result;
        }

    }

}
