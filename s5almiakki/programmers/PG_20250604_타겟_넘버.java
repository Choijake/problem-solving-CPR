
public class PG_20250604_타겟_넘버 {

    class Solution {

        private int[] numbers;
        private int target;
        private int answer = 0;

        public int solution(int[] numbers, int target) {
            this.numbers = numbers;
            this.target = target;
            dfs(0, 0);
            return this.answer;
        }

        private void dfs(int depth, int currentResult) {
            if (depth == this.numbers.length) {
                if (currentResult == target) {
                    this.answer++;
                }
                return;
            }
            dfs(depth + 1, currentResult + numbers[depth]);
            dfs(depth + 1, currentResult - numbers[depth]);
        }

    }

}
