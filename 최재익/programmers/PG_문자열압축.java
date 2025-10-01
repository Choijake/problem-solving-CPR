import java.util.*;

class PG_문자열압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length()==1)return 1;

        for(int size=1; size<=s.length()/2; size++){
            int cur = 0;
            StringBuilder sb = new StringBuilder();

            while(cur<s.length()){
                if(cur+size>s.length()){
                    sb.append(s.substring(cur, s.length()));
                    break;
                }

                String target = s.substring(cur, cur+size);
                int start = cur+size;
                int end = cur+size*2;
                int count = 1;

                while(end<=s.length()){

                    if(target.equals(s.substring(start, end))){
                        count++;
                        start = end;
                        end += size;
                    }
                    else break;
                }

                cur = start;

                if(count>1){
                    sb.append(count).append(target);
                }
                else{
                    sb.append(target);
                }
            }

            answer = Math.min(answer, sb.toString().length());

            // System.out.println(size+". "+sb.toString());
        }

        return answer;
    }
}