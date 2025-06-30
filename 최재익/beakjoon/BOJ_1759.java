import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1759 {
    static int L, C;
    static char[] result;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        String line = br.readLine().replaceAll(" ", "");
        arr = line.toCharArray();
        Arrays.sort(arr);

        result = new char[L];
        combination(0, 0);
    }

    private static void combination(int depth, int start){
        if(depth == L){
            if(check()){
                System.out.println(result);
            }
            return;
        }

        for(int i=start; i<arr.length; i++){
            result[depth] = arr[i];
            combination(depth+1, i+1);
        }
    }

    private static boolean check(){
        int vo = 0;
        int con = 0;
        for(char ch : result){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')vo++;
            else con++;
        }

        return vo>=1&&con>=2;
    }
}
