import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    private static int N, S;
    private static int[] numbers;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        subset(0, 0, 0, 0);
        System.out.println(result);
    }

    public static void subset(int depth, int sum, int count, int beforeCount){
        if(count>0&&beforeCount!=count&&sum==S){
            result++;
        }
        if(depth==N)return;

        subset(depth+1, sum, count, count);
        subset(depth+1, sum+numbers[depth], count+1, count);
    }
}
