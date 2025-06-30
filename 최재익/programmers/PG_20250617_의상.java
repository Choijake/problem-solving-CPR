import java.util.*;

class PG_20250617_의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] c : clothes){
            map.put(c[1], map.getOrDefault(c[1], 0)+1);
        }

        for(String s : map.keySet()){
            answer *= map.get(s)+1;
        }
        answer--;

        return answer;
    }
}