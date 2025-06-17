import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13414 {
    private static int K, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(int i=0; i<L; i++){
            String input = br.readLine();
            set.remove(input);
            set.add(input);
        }

        List<String> list = new ArrayList<>(set);
        int end = Math.min(list.size(), K);
        for(int i=0; i<end; i++){
            System.out.println(list.get(i));
        }
    }
}
