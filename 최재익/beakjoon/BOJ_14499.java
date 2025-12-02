import java.io.*;
import java.util.*;

public class BOJ_14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = {0, 0, 0, 0, 0, 0, 0};
        int[] idx = {x, y};
        int[] dr = {0, 0, 0, -1, 1};
        int[] dc = {0, 1, -1, 0, 0};

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            int cmd = Integer.parseInt(st.nextToken());

            int nextRow = idx[0]+dr[cmd];
            int nextCol = idx[1]+dc[cmd];

            if(nextRow<0 || nextCol<0 || nextRow>=N || nextCol>=M)continue;

            if(cmd == 1){
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
            }
            else if(cmd == 2){
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
            }
            else if(cmd == 3){
                int tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
            }
            else if(cmd == 4){
                int tmp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
            }

            idx[0] = nextRow;
            idx[1] = nextCol;

            if(map[idx[0]][idx[1]]==0){
                map[idx[0]][idx[1]] = dice[6];
            }
            else{
                dice[6] = map[idx[0]][idx[1]];
                map[idx[0]][idx[1]] = 0;
            }

            sb.append(dice[1]).append("\n");

            for(int j=1; j<7; j++){
                System.out.print(dice[j]+" ");
            }
            System.out.println();
        }

        System.out.print(sb);
    }
}
