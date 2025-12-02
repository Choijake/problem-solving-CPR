import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ_올바른배열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        int answer = 0;
        int count = 0;
        int loop = (n<5)?1:n;

        for(int i=0; i<loop; i++){
            int cur = list.get(i);
            int end = cur+4;

            for(int j=0; j<n-i; j++){
                int compare = list.get(i+j);

                if(compare>=cur && compare<=end){
                    count++;
                }
            }

            answer = Math.max(answer, count);
            count = 0;
        }

        System.out.print(5-answer);
    }
}