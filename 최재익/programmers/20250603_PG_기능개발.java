import java.util.*;

class Solution {
    private int[] progresses;
    private int[] speeds;
    private final int END = 100;

    public List<Integer> solution(int[] progresses, int[] speeds) {
        this.progresses = progresses;
        this.speeds = speeds;

        int[] days = getDaysToComplete();
        List<Integer> answer = new ArrayList<>();
        if(days.length==0)return answer;

        int deployDay = days[0];
        int count = 1;

        for(int i=1; i<days.length; i++){
            if(deployDay>=days[i]){
                count++;
            }else {
                answer.add(count);
                count = 1;
                deployDay = days[i];
            }
        }
        answer.add(count);

        return answer;
    }

    public int[] getDaysToComplete(){
        int[] days = new int[progresses.length];

        for(int i = 0; i<progresses.length; i++){
            int remaining = END-progresses[i];
            int day = 0;
            while(remaining>0){
                remaining-=speeds[i];
                day++;
            }
            days[i] = day;
        }

        for(int day : days){
            System.out.println(day);
        }

        return days;
    }
}