import java.util.*;

class PG_20250611_가장큰수 {
    public String solution(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(stringNumbers, (a,b)->(b+a).compareTo(a+b));

        if(stringNumbers[0].equals("0"))return "0";

        StringBuilder sb = new StringBuilder();
        for(String str : stringNumbers){
            sb.append(str);
        }

        return sb.toString();
    }
}
