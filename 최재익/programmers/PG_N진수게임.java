import java.util.*;
class PG_N진수게임 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int MAX_SIZE = t*m;

        int number = 0;
        while(sb.length()<t*m){
            sb.append(Integer.toString(number++, n));
        }

        String result = sb.toString();
        int idx = p-1;
        int count = 0;
        StringBuilder answer = new StringBuilder();
        while(count<t){
            answer.append(result.charAt(idx));
            idx+=m;
            count++;
        }

        return answer.toString().toUpperCase();
    }
}