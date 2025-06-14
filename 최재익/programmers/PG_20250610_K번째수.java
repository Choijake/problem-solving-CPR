import java.util.*;

class PG_20250610_K번째수 {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for(int[] command : commands){
            int start = command[0];
            int end = command[1];
            int target = command[2];

            int[] part = Arrays.copyOfRange(array, start-1, end);
            Arrays.sort(part);
            answer.add(part[target-1]);
        }

        return answer;
    }
}
