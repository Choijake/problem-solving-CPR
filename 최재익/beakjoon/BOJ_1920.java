import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class BOJ_1920 {
    static int N, M;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            long number = Long.parseLong(st.nextToken());
            sb.append(binarySearch(number)).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(long number){
        int hi = arr.length;
        int lo = 0;
        int mid ;

        while(lo+1<hi){
            mid = (lo+hi)/2;

            if(number<arr[mid])hi = mid;
            else lo = mid;
        }

        return arr[lo]==number?1:0;
    }
}
