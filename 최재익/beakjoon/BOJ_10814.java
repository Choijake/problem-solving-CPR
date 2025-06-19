import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10814 {
    public static class Info{
        int age;
        String name;
        int idx;

        public Info(int age, String name, int idx){
            this.age = age;
            this.name = name;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        List<Info> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Info(age, name, i));
        }

        Collections.sort(list, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.age!=o2.age)return o1.age-o2.age;
                else return o1.idx-o2.idx;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Info info : list){
            sb.append(info.age).append(" ").append(info.name).append("\n");
        }

        System.out.println(sb);
    }
}
