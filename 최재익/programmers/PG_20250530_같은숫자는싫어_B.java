import java.util.*;

public class PG_20250530_같은숫자는싫어_B {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int preNum = 10;

        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            if(preNum!=num)answer.add(num);
            preNum = num;
        }

        return answer;
    }
}
