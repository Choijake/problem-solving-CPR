import java.io.*;
import java.util.*;

public class BOJ_12100 {
    static int answer;
    static int[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        for (int dir = 1; dir <= 4; dir++) {
            dfs(dir, 0, copy(map));
        }

        System.out.print(answer);
    }

    static void dfs(int direction, int depth, int[][] map) {
        if (depth == 5) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            answer = Math.max(max, answer);
            return;
        }

        if(direction==1){
            for(int row=0; row<N; row++){
                for(int col=N-1; col>=0; col--){
                    int cur = map[row][col];
                    if(cur==0) continue;

                    int idx = col-1;
                    while(idx>=0){
                        if(map[row][idx] == 0){
                            idx--;
                            continue;
                        }
                        if(map[row][idx] == cur){
                            map[row][col] = cur * 2;
                            map[row][idx] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }

                int target = N-1;
                for(int col=N-1; col>=0; col--){
                    if(map[row][col] != 0){
                        map[row][target] = map[row][col];
                        if(target!=col){
                            map[row][col] = 0;
                        }
                        target--;
                    }
                }
            }
        }
        else if(direction==2){
            for(int col=0; col<N; col++){
                for(int row=N-1; row>=0; row--){
                    int cur = map[row][col];
                    if(cur==0) continue;

                    int idx = row-1;
                    while(idx>=0){
                        if(map[idx][col] == 0){
                            idx--;
                            continue;
                        }
                        if(map[idx][col] == cur){
                            map[row][col] = cur * 2;
                            map[idx][col] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }

                int target = N-1;
                for(int row=N-1; row>=0; row--){
                    if(map[row][col] != 0){
                        map[target][col] = map[row][col];
                        if(target!=row){
                            map[row][col] = 0;
                        }
                        target--;
                    }
                }
            }
        }
        else if(direction==3){
            for(int row=0; row<N; row++){
                for(int col=0; col<N; col++){
                    int cur = map[row][col];
                    if(cur==0) continue;

                    int idx = col+1;
                    while(idx<N){
                        if(map[row][idx] == 0){
                            idx++;
                            continue;
                        }
                        if(map[row][idx] == cur){
                            map[row][col] = cur * 2;
                            map[row][idx] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }

                int target = 0;
                for(int col=0; col<N; col++){
                    if(map[row][col] != 0){
                        map[row][target] = map[row][col];
                        if(target!=col){
                            map[row][col] = 0;
                        }
                        target++;
                    }
                }
            }
        }
        else{
            for(int col=0; col<N; col++){
                for(int row=0; row<N; row++){
                    int cur = map[row][col];
                    if(cur==0) continue;

                    int idx = row+1;
                    while(idx<N){
                        if(map[idx][col] == 0){
                            idx++;
                            continue;
                        }
                        if(map[idx][col] == cur){
                            map[row][col] = cur * 2;
                            map[idx][col] = 0;
                            break;
                        } else {
                            break;
                        }
                    }
                }

                int target = 0;
                for(int row=0; row<N; row++){
                    if(map[row][col] != 0){
                        map[target][col] = map[row][col];
                        if(target!=row){
                            map[row][col] = 0;
                        }
                        target++;
                    }
                }
            }
        }

        dfs(1, depth+1, copy(map));
        dfs(2, depth+1, copy(map));
        dfs(3, depth+1, copy(map));
        dfs(4, depth+1, copy(map));
    }

    static int[][] copy(int[][] map){
        int[][] copy = new int[N][N];
        for(int i=0; i<N; i++){
            copy[i] = map[i].clone();
        }

        return copy;
    }
}
