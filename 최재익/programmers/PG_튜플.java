import java.util.*;

class PG_튜플 {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();

        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] arr = s.split("-");
        Arrays.sort(arr, Comparator.comparingInt(str->str.length()));

        for(String a : arr){
            String[] t = a.split(",");
            for(int i=0; i<t.length; i++){
                int number = Integer.parseInt(t[i]);
                if(answer.contains(number))continue;
                answer.add(number);
            }
        }

        return answer;
    }
}