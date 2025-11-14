import java.io.*;
import java.util.*;

public class BOJ_14889 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N+1];
        answer = Integer.MAX_VALUE;

        combination(0, 1);

        System.out.print(answer);
    }

    static void combination(int depth, int start){
        if(depth == N/2){
            int startPoint = 0;
            int linkPoint = 0;

            for(int i=0; i<N; i++){
                for(int j=i+1; j<=N; j++){
                    if(visited[i] && visited[j]){
                        startPoint += map[i][j];
                        startPoint += map[j][i];
                    }
                    else if(!visited[i] && !visited[j]){
                        linkPoint += map[i][j];
                        linkPoint += map[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(startPoint-linkPoint));

            if(answer == 0){
                System.out.print(0);
                System.exit(0);
            }
        }

        for(int idx = start; idx<=N; idx++){
            if(visited[idx])continue;
            visited[idx] = true;
            combination(depth+1, idx+1);
            visited[idx] = false;
        }
    }
}
