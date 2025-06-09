class Solution {
    private int count = 0;
    private int[] numbers;
    private int target;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        explore(0, 0);

        return count;
    }

    private void explore(int number, int depth){
        if(depth == numbers.length){
            if(number == target){
                count++;
            }
            return;
        }

        explore(number-numbers[depth], depth+1);
        explore(number+numbers[depth], depth+1);
    }
}