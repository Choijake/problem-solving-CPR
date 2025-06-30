import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1431 {
    static int N;
    static List<char[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String line = br.readLine();
            list.add(line.toCharArray());
        }

        Collections.sort(list, new Comparator<char[]>() {
            @Override
            public int compare(char[] o1, char[] o2) {
                if(o1.length!=o2.length)return o1.length-o2.length;

                int a = getSum(o1);
                int b = getSum(o2);
                if(a!=b)return a-b;
                else return Arrays.toString(o1).compareToIgnoreCase(Arrays.toString(o2));
            }
        });

        for(char[] arr : list){
            System.out.println(arr);
        }
    }

    private static int getSum(char[] o){
        int sum = 0;
        for(int num : o){
            if(num >= '0' && num <= '9'){
                sum += (num - '0');
            }
        }
        return sum;
    }
}
