import java.util.*;

public class PG_20250530_같은숫자는싫어_A {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            int number = arr[i];

            if(i==0){
                stack.push(number);
                continue;
            }

            int lastNumber = stack.peek();
            if(number==lastNumber)continue;
            else stack.push(number);
        }

        return stack;
    }
}
