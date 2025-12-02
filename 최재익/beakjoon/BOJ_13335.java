import java.io.*;
import java.util.*;

public class BOJ_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> bridge = new ArrayDeque<>();
        Queue<Integer> truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            truck.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<W; i++){
            bridge.add(0);
        }

        int count = 0;
        int bridgeWeight = 0;
        while(!bridge.isEmpty()){
            count++;

            bridgeWeight -= bridge.poll();

            if(!truck.isEmpty()){
                if(bridgeWeight+truck.peek()<=L && bridge.size()+1<=W){
                    bridgeWeight += truck.peek();
                    bridge.add(truck.poll());
                }
                else bridge.add(0);
            }
        }

        System.out.print(count);
    }
}
