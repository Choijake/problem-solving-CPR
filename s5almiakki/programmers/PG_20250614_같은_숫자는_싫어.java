import java.util.*;

public class PG_20250614_같은_숫자는_싫어 {

    public class Solution1 {

        public int[] solution(int[] arr) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i : arr) {
                if (stack.isEmpty() || !stack.getLast().equals(i)) {
                    stack.addLast(i);
                }
            }
            return stack.stream().mapToInt(i -> i).toArray();
        }
    }

    public class Solution2 {

        public int[] solution(int[] arr) {
            List<Integer> stack = new ArrayList<>();
            for (int i : arr) {
                if (stack.isEmpty() || !stack.get(stack.size() - 1).equals(i)) {
                    stack.add(i);
                }
            }
            return stack.stream().mapToInt(i -> i).toArray();
        }
    }

}
