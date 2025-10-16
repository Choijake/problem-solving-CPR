
public class PG_20251005_연속된_부분_수열의_합 {

    class Solution {

        public int[] solution(int[] sequence, int k) {
            int[] accumulations = new int[sequence.length + 1];
            for (int i = 0; i < sequence.length; i++) {
                accumulations[i + 1] = sequence[i] + accumulations[i];
            }
            int head = 0;
            int tail = 1;
            int[] answer = new int[2];
            int gap = Integer.MAX_VALUE;
            do {
                int sum = accumulations[tail] - accumulations[head];
                if (sum < k) {
                    tail++;
                } else if (sum > k) {
                    head++;
                } else {
                    if (tail - head < gap) {
                        answer[0] = head;
                        answer[1] = tail;
                        gap = tail - head;
                    }
                    head++;
                }
            } while (tail < accumulations.length);
            answer[1]--;
            return answer;
        }

    }

}
