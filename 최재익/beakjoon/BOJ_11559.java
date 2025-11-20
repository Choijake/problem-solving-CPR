import java.io.*;
import java.util.*;

public class BOJ_11559 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        map = new char[12][6];
        for(int i=0; i<12; i++){
            map[i] = br.readLine().toCharArray();
        }

        int seq = 0;
        while(true){
            boolean boom = false;
            visited = new boolean[12][6];

            List<int[]> toBoom = new ArrayList<>();

            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(!visited[i][j] && map[i][j] != '.') {
                        List<int[]> group = bfs(i, j, map[i][j]);

                        if(group.size() >= 4){
                            boom = true;
                            toBoom.addAll(group);
                        }
                    }
                }
            }

//            System.out.println("탐색 시작 위치 : "+i+", "+j);
            if(boom)seq++;
            else break;

            for(int[] p : toBoom){
                map[p[0]][p[1]] = '.';
            }

            drop();

        }

        System.out.print(seq);
    }

    static void drop(){
        for(int col=0; col<6; col++){
            int write = 11;

            for(int row=11; row>=0; row--){
                if(map[row][col] != '.'){
                    map[write][col] = map[row][col];
                    if(write!=row)map[row][col] = '.';
                    write--;
                }
            }
        }
    }

    static List<int[]> bfs(int row, int col, char color){
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> group = new ArrayList<>();
        queue.add(new int[]{row, col});
        group.add(new int[]{row, col});
        visited[row][col] = true;


        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(nr<0 || nc<0 || nr>=12 || nc>=6)continue;
                if(visited[nr][nc])continue;

                if(map[nr][nc]==color){
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                    group.add(new int[]{nr, nc});
                }
            }
        }

        return group;
    }
}
