import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        char[] arr = word.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(char ch : arr){
            char key = Character.toLowerCase(ch);
            int value = map.getOrDefault(key, 0)+1;
            map.put(key, value);
            max = Math.max(max, value);
        }

        int count = 0;
        char result=' ';
        for(Character key : map.keySet()){
            if(map.get(key)==max){
                result = key;
                count++;
            }
        }

        result = count==1?Character.toUpperCase(result):'?';

        System.out.println(result);
    }
}
