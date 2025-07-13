import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int[] floors, dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        floors = new int[N+1];
        for(int i=1; i<=N; i++){
            floors[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N+1];
        dp[1] = floors[1];
        if(N>=2)dp[2] = floors[1]+floors[2];

        for(int i=3; i<=N; i++){
            dp[i] = Math.max((floors[i-1]+dp[i-3]), dp[i-2]) + floors[i];
        }

        System.out.println(dp[N]);
    }
}
