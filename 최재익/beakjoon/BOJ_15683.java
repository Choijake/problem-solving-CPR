import java.io.*;
import java.util.*;

public class BOJ_15683 {
    static int N, M;
    static int[][] map, copyMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<int[]> cctv;
    static int[] output;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctv = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>=1 && map[i][j]<=5){
                    cctv.add(new int[]{map[i][j], i ,j});
                }
            }
        }

        output = new int[cctv.size()];
        answer = Integer.MAX_VALUE;

        permutation(0);

        System.out.print(answer);
    }

    static void permutation(int depth){
        if(depth == cctv.size()){
            copyMap = new int[N][M];
            for(int i=0; i<N; i++){
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }

            for(int i=0; i<output.length; i++){
                direction(cctv.get(i), output[i]);
            }

            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(copyMap[i][j]==0)count++;
                }
            }

            answer = Math.min(answer, count);

            return;
        }

        for(int i=0; i<4; i++){
            output[depth] = i;
            permutation(depth+1);
        }
    }

    static void direction(int[] c, int d){
        int number = c[0];
        int row = c[1];
        int col = c[2];

        if(number == 1){
            if(d == 0)watch(row, col, 0);
            else if(d == 1)watch(row, col, 1);
            else if(d == 2)watch(row, col, 2);
            else if(d == 3)watch(row, col, 3);
        }
        else if(number == 2){
            if(d==0 || d==2){
                watch(row, col, 0);
                watch(row, col, 2);
            }
            else{
                watch(row, col, 1);
                watch(row, col, 3);
            }
        }
        else if(number == 3){
            if(d == 0){
                watch(row, col, 0);
                watch(row, col, 1);
            }
            else if(d == 1){
                watch(row, col, 1);
                watch(row, col, 2);
            }
            else if(d == 2){
                watch(row, col, 2);
                watch(row, col, 3);
            }
            else if(d == 3){
                watch(row, col, 0);
                watch(row, col, 3);
            }
        }
        else if(number == 4){
            if(d == 0){
                watch(row, col, 0);
                watch(row, col, 1);
                watch(row, col, 3);
            }
            else if(d == 1){
                watch(row, col, 0);
                watch(row, col, 1);
                watch(row, col, 2);
            }
            else if(d == 2){
                watch(row, col, 1);
                watch(row, col, 2);
                watch(row, col, 3);
            }
            else if(d == 3){
                watch(row, col, 0);
                watch(row, col, 2);
                watch(row, col, 3);
            }
        }
        else if(number == 5){
            watch(row, col, 0);
            watch(row, col, 1);
            watch(row, col, 2);
            watch(row, col, 3);
        }
    }

    static void watch(int row, int col, int d){
        int nextRow = row;
        int nextCol = col;

        while(true){
            nextRow += dr[d];
            nextCol += dc[d];

            if(nextRow<0 || nextCol<0 || nextRow>=N || nextCol>=M)break;

            if(copyMap[nextRow][nextCol]==6)break;
            if(copyMap[nextRow][nextCol]>=0 && copyMap[nextRow][nextCol]<=5){
                copyMap[nextRow][nextCol] = -1;
            }
        }
    }
}
