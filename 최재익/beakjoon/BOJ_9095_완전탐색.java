import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_완전탐색 {
    static int T;
    static int n, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            n = Integer.parseInt(br.readLine());
            result = 0;
            permutation(0, 0);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void permutation(int depth, int sum){
        if(depth == n){
            if(sum==n)result++;
            return;
        }
        if(sum==n){
            result++;
            return;
        }

        permutation(depth+1, sum+1);
        permutation(depth+1, sum+2);
        permutation(depth+1, sum+3);
    }
}
