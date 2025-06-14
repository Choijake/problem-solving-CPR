import java.util.*;

class PG_20250604_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        for(String c : completion){
            map.put(c, map.get(c)-1);
        }

        String answer = "";
        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer = key;
            }
        }

        return answer;
    }
}
