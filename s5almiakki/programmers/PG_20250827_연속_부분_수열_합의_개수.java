import java.util.*;

public class PG_20250827_연속_부분_수열_합의_개수 {

    class Solution {

        public int solution(int[] elements) {
            int[] extendedElements = Arrays.copyOf(elements, (elements.length << 1) - 1);
            System.arraycopy(elements, 0, extendedElements, elements.length, elements.length - 1);
            boolean[] visited = new boolean[1_000_000];
            int answer = 0;
            for (int base = 0; base < elements.length; base++) {
                int sum = 0;
                for (int offset = 0; offset < elements.length; offset++) {
                    sum += extendedElements[base + offset];
                    if (visited[sum]) {
                        continue;
                    }
                    visited[sum] = true;
                    answer++;
                }
            }
            return answer;
        }

    }

}
