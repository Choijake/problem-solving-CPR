import java.util.*;

public class PG_20250920_숫자_변환하기 {

    class Solution1 {

        public int solution(int x, int y, int n) {
            int[] counts = new int[y + 1];
            Arrays.fill(counts, Integer.MAX_VALUE);
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] { x, 0 });
            counts[x] = 0;
            do {
                int[] currentElement = queue.remove();
                int newCount = currentElement[1] + 1;
                int newValue = currentElement[0] + n;
                if (newValue <= y && counts[newValue] > newCount) {
                    queue.add(new int[] { newValue, newCount });
                    counts[newValue] = newCount;
                }
                newValue = currentElement[0] << 1;
                if (newValue <= y && counts[newValue] > newCount) {
                    queue.add(new int[] { newValue, newCount });
                    counts[newValue] = newCount;
                }
                newValue = currentElement[0] * 3;
                if (newValue <= y && counts[newValue] > newCount) {
                    queue.add(new int[] { newValue, newCount });
                    counts[newValue] = newCount;
                }
            } while (!queue.isEmpty());
            return counts[y] == Integer.MAX_VALUE ? -1 : counts[y];
        }

    }

}
