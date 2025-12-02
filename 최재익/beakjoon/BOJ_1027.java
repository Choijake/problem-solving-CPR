import java.io.*;
import java.util.*;

public class BOJ_1027 {
    static int N;
    static int[] buildings;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        buildings = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<buildings.length; i++){
            int x1 = i;
            int y1 = buildings[i];

//            System.out.println("기준 빌딩 : "+i+" (높이: "+buildings[i]+")");

            for(int j=0; j<buildings.length; j++){
                if(i==j)continue;

                int x2 = j;
                int y2 = buildings[j];

//                System.out.println("  비교 대상 빌딩 : "+j+" (높이: "+buildings[j]+")");

                double slope = (double)(y2-y1)/(x2-x1);
                int start = Math.min(x1, x2);
                int end = Math.max(x1, x2);

                boolean blocked = false;

                for(int k=start+1; k<end; k++){
                    int x3 = k;
                    int y3 = buildings[k];

                    double height = (x3-start) * slope + buildings[start];

//                    System.out.printf("    중간 빌딩 %d (높이: %d), 기대 높이: %d → %s\n",
//                            x3, y3, height, (height > y3 ? "보임 유지" : "가림"));

                    if(height<=y3){
                        blocked = true;
                        break;
                    }
                }

                if(!blocked)arr[i]++;

//                System.out.println("  카운트 결과 : "+arr[i]);
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[N-1]);
    }
}
//기준 빌딩, 비교 대상 빌딩 사이에 하나라도 blocked된게 있으면 안되기때문에 이걸 고려했어야함.
// slope의 타입을 int로해서, a와 b 사이의 중간 빌딩이 블락되는 범위가 달라짐