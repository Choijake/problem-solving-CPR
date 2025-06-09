import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int priority : priorities){
            queue.add(priority);
        }

        int answer = 0;
        while(!queue.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i]==queue.peek()){
                    queue.poll();
                    answer++;

                    if(location==i){
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}