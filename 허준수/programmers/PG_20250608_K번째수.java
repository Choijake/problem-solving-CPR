import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        int idx = 0;

        for(int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            for(int i = command[0]; i <= command[1]; i++){
                list.add(array[i-1]);
            }

            Collections.sort(list);
            answer[idx++] = list.get(command[2] - 1);
        }
        System.out.println("answer = " + Arrays.toString(answer));
        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution.solution(array, commands);
    }
}