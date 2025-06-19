import java.util.*;

public class PG_20250619_소수_찾기 {

    class Solution1 {

        private final int[] isPrimes = new int[10_000_000]; // 1: prime number, else: not prime number

        private char[] numbers;
        private int isVisited; // bit mask
        private int currentNumber = 0;
        private Set<Integer> answer = new HashSet<>();

        // init isPrimes
        {
            for (int number = 2; number < isPrimes.length; number++) {
                if (isPrimes[number] == -1) {
                    continue;
                }
                isPrimes[number] = 1;
                for (int multiple = (number << 1); multiple < isPrimes.length; multiple += number) {
                    isPrimes[multiple] = -1;
                }
            }
        }

        public int solution(String numbers) {
            this.numbers = numbers.toCharArray();
            dfs(0);
            return this.answer.size();
        }

        private void dfs(int depth) {
            if (isPrimes[currentNumber] == 1) {
                this.answer.add(currentNumber);
            }
            if (depth == this.numbers.length) {
                return;
            }
            for (int i = 0; i < this.numbers.length; i++) {
                if ((isVisited & (1 << i)) != 0) {
                    continue;
                }
                this.currentNumber *= 10;
                this.currentNumber += numbers[i] - '0';
                isVisited |= (1 << i);
                dfs(depth + 1);
                this.currentNumber /= 10;
                isVisited &= ~(1 << i);
            }
        }

    }

    class Solution2 {

        private int[] isPrimes; // 1: prime number, else: not prime number

        private char[] numbers;
        private int isVisited; // bit mask
        private int currentNumber = 0;
        private Set<Integer> answer = new HashSet<>();

        public int solution(String numbers) {
            this.numbers = numbers.toCharArray();
            int maxNumber = 1;
            for (int i = 0; i < this.numbers.length; i++) {
                maxNumber *= 10;
            }
            isPrimes = new int[maxNumber];
            for (int number = 2; number < isPrimes.length; number++) {
                if (isPrimes[number] == -1) {
                    continue;
                }
                isPrimes[number] = 1;
                for (int multiple = (number << 1); multiple < isPrimes.length; multiple += number) {
                    isPrimes[multiple] = -1;
                }
            }
            dfs(0);
            return this.answer.size();
        }

        private void dfs(int depth) {
            if (isPrimes[currentNumber] == 1) {
                this.answer.add(currentNumber);
            }
            if (depth == this.numbers.length) {
                return;
            }
            for (int i = 0; i < this.numbers.length; i++) {
                if ((isVisited & (1 << i)) != 0) {
                    continue;
                }
                this.currentNumber *= 10;
                this.currentNumber += numbers[i] - '0';
                isVisited |= (1 << i);
                dfs(depth + 1);
                this.currentNumber /= 10;
                isVisited &= ~(1 << i);
            }
        }

    }

}
