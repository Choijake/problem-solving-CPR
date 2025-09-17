import java.util.*;

public class PG_20250917_택배상자 {

    class Solution {

        public int solution(int[] order) {
            Set<Integer> mainSet = new HashSet<>();
            Queue<Integer> mainQueue = new ArrayDeque<>();
            for (int i = 1; i <= order.length; i++) {
                mainSet.add(i);
                mainQueue.add(i);
            }
            Deque<Integer> secondaryStack = new ArrayDeque<>();
            int answer = 0;
            for (int target : order) {
                boolean mainQueueContainsTarget = false;
                // 기존 벨트에 목표 상자가 있는 경우
                if (mainSet.contains(target)) {
                    mainQueueContainsTarget = true;
                    answer++;
                    // 기존 벨트에서 목표 상자 찾을 때까지 상자 빼서 보조 벨트에 넣기
                    do {
                        Integer box = mainQueue.remove();
                        mainSet.remove(box);
                        if (box == target) {
                            break;
                        }
                        secondaryStack.push(box);
                    } while (true);
                }
                // 기존 벨트에서 찾았으면 보조 벨트에서 찾을 필요 없음
                if (mainQueueContainsTarget) {
                    continue;
                }
                // 보조 벨트에 마지막으로 넣은 게 목표랑 다르면 트럭에 더 실을 수 없음
                if (secondaryStack.pop() != target) {
                    break;
                }
                answer++;
            }
            return answer;
        }

    }

}
