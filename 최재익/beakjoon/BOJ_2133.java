import java.io.*;
import java.util.*;

public class BOJ_2133 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N%2!=0){
            System.out.print(0);
            return;
        }

        int[] dp = new int[N+1];
        dp[2] = 3;
        for(int i=4; i<=N; i+=2){
            dp[i] = dp[i-2] * dp[2];

            for(int j=i-4; j>0; j-=2){
                dp[i] += dp[j]*2;
            }
            dp[i]+=2;
        }

        System.out.print(dp[N]);
    }
}
