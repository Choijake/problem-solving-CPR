import java.util.*;

public class PG_20250909_뒤에_있는_큰_수_찾기 {

    class Solution {

        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Arrays.fill(answer, -1);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = answer.length - 2; i >= 0; i--) {
                if (numbers[i] < numbers[i + 1]) {
                    answer[i] = numbers[i + 1];
                    stack.push(numbers[i + 1]);
                    continue;
                }
                while (!stack.isEmpty()) {
                    int element = stack.pop();
                    if (numbers[i] < element) {
                        answer[i] = element;
                        stack.push(element);
                        break;
                    }
                }
            }
            return answer;
        }

    }

}
