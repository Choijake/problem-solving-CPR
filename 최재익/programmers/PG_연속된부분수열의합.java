import java.util.*;

class PG_연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int start = 0, end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while(start<n){
            while(end<n && sum<k){
                sum += sequence[end++];
            }

            if(sum==k){
                int length = end-start;
                if(length<minLen){
                    minLen=length;
                    answer[0] = start;
                    answer[1] = end-1;
                }
            }

            sum -= sequence[start];
            start++;
        }

        return answer;
    }
}