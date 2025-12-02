import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16401 {
    static int M, N;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snack = new int[N];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        int lo = 0;
        int hi = 1_000_000_001;
        while(lo+1<hi){
            int mid = (lo+hi)/2;
            int count = getCount(mid);

            if(count<M){
                hi = mid;
            }
            else if(count>=M){
                lo = mid;
            }
        }

        System.out.println(lo);
    }

    static int getCount(int length){
        int count = 0;
        for(int i=0; i<snack.length; i++){
            count += snack[i]/length;
        }
        return count;
    }
}
