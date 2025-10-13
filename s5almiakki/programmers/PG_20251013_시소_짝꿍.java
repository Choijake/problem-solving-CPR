import java.util.*;

public class PG_20251013_시소_짝꿍 {

    class Solution {

        private static final int[] DISTANCES = { 2, 3, 4 };

        public long solution(int[] weights) {
            Map<Integer, Integer> weightCnts = new HashMap<>();
            Map<Integer, Integer> torqueCnts = new HashMap<>();
            for (int weight : weights) {
                weightCnts.put(weight, weightCnts.getOrDefault(weight, 0) + 1);
                for (int distance : DISTANCES) {
                    int torque = weight * distance;
                    torqueCnts.put(torque, torqueCnts.getOrDefault(torque, 0) + 1);
                }
            }
            long answer = 0L;
            // 몸무게가 같은 사람끼리는 거리 2, 3, 4 중 한 번만 고려해야 하므로 이중 2개는 미리 빼둠
            for (Map.Entry<Integer, Integer> entry : weightCnts.entrySet()) {
                long value = entry.getValue();
                if (value > 1L) {
                    answer -= (value - 1L) * value;
                }
            }
            // 토크가 같은 두 사람을 순서 없이 고르는 경우의 수
            for (Map.Entry<Integer, Integer> entry : torqueCnts.entrySet()) {
                long value = entry.getValue();
                if (value > 1L) {
                    answer += ((value - 1L) * value) >> 1L;
                }
            }
            return answer;
        }

    }

}
