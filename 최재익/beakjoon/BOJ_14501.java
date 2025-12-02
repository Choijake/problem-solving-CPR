import java.io.*;
import java.util.*;

public class BOJ_14501 {
    static int[][] arr;
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = -1;

        combination(0, 0);

        System.out.print(answer);
    }

    static void combination(int day, int pay){
        if(day >= N ){
            //System.out.print(pay+" ");
            answer = Math.max(answer, pay);
            return;
        }

        combination(day+1, pay);

        if(day + arr[day][0] <= N){
            combination(day + arr[day][0], pay + arr[day][1]);
        }
    }
}
