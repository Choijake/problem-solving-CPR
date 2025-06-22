import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    static long a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long result = calc(a, b);

        System.out.println(result);
    }

    public static long calc(long a, long exp){
        if(exp==1)return a%c;

        long temp = calc(a, exp/2);
        long squared = (temp * temp) % c;

        if(exp % 2 == 1){
            return (squared * (a % c)) % c;
        }
        return squared;
    }
}
