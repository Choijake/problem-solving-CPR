import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
    static int N;
    static int[][] map, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][N];
        dp[0][0] = map[0][0];
        for(int i=1; i<N; i++){
            for(int j=0; j<i+1; j++){
                if(j==0)dp[i][j] = dp[i-1][j] + map[i][j];
                else if(j==i)dp[i][j] = dp[i-1][j-1] + map[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + map[i][j];
            }
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            answer = Math.max(dp[N-1][i], answer);
        }

        System.out.println(answer);
    }
}
