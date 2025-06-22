import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];
        int max = 0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
            max = Math.max(max, num);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=max; i++){
            if(arr[i]<=0)continue;

            for(int j=0; j<arr[i]; j++){
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }
}
