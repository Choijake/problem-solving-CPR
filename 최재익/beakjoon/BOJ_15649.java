import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static StringBuilder sb;
    static int[] arr;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N+1];
        sb = new StringBuilder();

        permutation(0);

        System.out.println(sb);
    }

    static void permutation(int depth){
        if(depth==M){
            for(int num : arr){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i])continue;
            arr[depth] = i;
            visited[i] = true;
            permutation(depth+1);
            visited[i] = false;
        }
    }
}
