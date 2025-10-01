import java.util.*;

class PG_할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        total:
        for(int i=0; i<=discount.length-10; i++){
            for(int j=0; j<want.length; j++){
                map.put(want[j], number[j]);
            }

            for(int j=i; j<i+10; j++){
                if(!map.containsKey(discount[j]))continue;
                if(map.get(discount[j])==0)continue;

                int cur = map.get(discount[j]);
                map.put(discount[j], cur-1);
            }

            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue()>0)continue total;
            }

            answer++;
        }

        return answer;
    }
}