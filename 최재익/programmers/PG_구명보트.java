import java.util.*;

class PG_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int left = 0;
        int right = people.length-1;

        while(left<=right){
            if(people[left]+people[right] <= limit){
                left++;
                right--;
            }else{
                right--;
            }
            answer++;
        }

        return answer;
    }
}
//그리디 전략 : 가장 가벼운 사람을 가장 무거운 사람과 배치
//투포인터로 구현