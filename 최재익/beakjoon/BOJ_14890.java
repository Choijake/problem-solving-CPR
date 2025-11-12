import java.io.*;
import java.util.*;

public class BOJ_14890 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        //행 검사
        for(int row=0; row<N; row++){
            boolean possible = true;
            boolean[] installed = new boolean[N];

            for(int col=1; col<N; col++){
                //두 칸 이상 차이나면 X
                if(Math.abs(map[row][col-1]-map[row][col]) > 1){
                    possible = false;
                    break;
                }

                //이전 높이 < 현재 높이
                if(map[row][col-1] < map[row][col]){
                    //범위 체크
                    if(col-L < 0){
                        possible = false;
                        continue;
                    }

                    // L 길이의 길에 설치할 수 없는 경우
                    boolean canInstall = true;
                    int height = map[row][col-1];
                    for(int idx=col-1; idx>=col-L; idx--){
                        if(installed[idx] || map[row][idx]!=height){
                            canInstall = false;
                            possible = false;
                            break;
                        }
                    }

                    if(canInstall){
                        for(int idx=col-1; idx>=col-L; idx--){
                            installed[idx] = true;
                        }
                    }
                }
                //이전 높이 > 현재 높이
                else if(map[row][col-1] > map[row][col]){
                    //범위 체크
                    if(col+L-1 >= N){
                        possible = false;
                        continue;
                    }

                    // L 길이의 길에 설치할 수 없는경우
                    boolean canInstall = true;
                    int height = map[row][col];
                    for(int idx=col; idx<=col+L-1; idx++){
                        if(installed[idx] || map[row][idx]!=height){
                            canInstall = false;
                            possible = false;
                            break;
                        }
                    }

                    if(canInstall){
                        for(int idx=col; idx<=col+L-1; idx++){
                            installed[idx] = true;
                        }
                    }
                }
            }

            if(possible){
                //System.out.println("행 : "+row);
                answer++;
            }
        }

        //열 검사
        for(int col=0; col<N; col++){
            boolean possible = true;
            boolean[] installed = new boolean[N];

            for(int row=1; row<N; row++){
                //두 칸 이상 차이나면 X
                if(Math.abs(map[row-1][col]-map[row][col]) > 1){
                    possible = false;
                    break;
                }

                //이전 높이 < 현재 높이
                if(map[row-1][col] < map[row][col]){
                    //범위 체크
                    if(row-L < 0){
                        possible = false;
                        continue;
                    }

                    // L 길이의 길에 설치할 수 없는 경우
                    boolean canInstall = true;
                    int height = map[row-1][col];
                    for(int idx=row-1; idx>=row-L; idx--){
                        if(installed[idx] || map[idx][col]!=height){
                            canInstall = false;
                            possible = false;
                            break;
                        }
                    }

                    if(canInstall){
                        for(int idx=row-1; idx>=row-L; idx--){
                            installed[idx] = true;
                        }
                    }
                }
                //이전 높이 > 현재 높이
                else if(map[row-1][col] > map[row][col]){
                    //범위 체크
                    if(row+L-1 >= N){
                        possible = false;
                        continue;
                    }

                    // L 길이의 길에 설치할 수 없는경우
                    boolean canInstall = true;
                    int height = map[row][col];
                    for(int idx=row; idx<=row+L-1; idx++){
                        if(installed[idx] || map[idx][col]!=height){
                            canInstall = false;
                            possible = false;
                            break;
                        }
                    }

                    if(canInstall){
                        for(int idx=row; idx<=row+L-1; idx++){
                            installed[idx] = true;
                        }
                    }
                }
            }

            if(possible){
                //System.out.println("열 : "+col);
                answer++;
            }
        }

        System.out.print(answer);
    }
}
