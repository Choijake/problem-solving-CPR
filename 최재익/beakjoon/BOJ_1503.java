import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ_1503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] isInSet = new boolean[1002];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            isInSet[Integer.parseInt(st.nextToken())] = true;
        }

        int answer = Integer.MAX_VALUE;
        for(int x=1; x<=1001; x++){
            for(int y=1; y<=1001; y++){
                for(int z=1; z<=1001; z++){
                    if(isInSet[x] || isInSet[y] || isInSet[z])continue;

                    int compare = Math.abs(N-(x*y*z));
                    answer = Math.min(answer, compare);
                }
            }
        }

        System.out.print(answer);
    }
}
