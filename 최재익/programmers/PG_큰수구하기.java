import java.util.*;

class PG_큰수구하기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int remainLength = number.length()-k;
        int start = 0;

        while(start<number.length() && answer.length()<remainLength){
            int end = k + answer.length();
            int max = 0;

            for(int i=start; i<=end; i++){
                if(number.charAt(i)-'0' > max){
                    max = number.charAt(i)-'0';
                    start = i+1;
                }
            }

            answer.append(max);
        }

        return answer.toString();
    }
}