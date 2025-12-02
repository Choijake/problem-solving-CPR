import java.util.*;

class PG_롤케이크자르기 {
    public int solution(int[] topping) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int one=0;
        int two=0;

        for(int i=0; i<topping.length; i++){
            if(!map1.containsKey(topping[i])){
                map1.put(topping[i], 1);
                one++;
            }else{
                map1.put(topping[i], map1.get(topping[i])+1);
            }
        }

        int answer = 0;
        for(int i=0; i<topping.length; i++){
            int now = topping[i];
            map1.put(now, map1.get(now)-1);
            if(map1.get(now)==0){
                one--;
            }

            if(!map2.containsKey(now)){
                map2.put(now, 1);
                two++;
            }

            if(one==two)answer++;
        }

        return answer;
    }
}