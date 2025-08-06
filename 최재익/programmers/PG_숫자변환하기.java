import java.util.*;

class PG_숫자변환하기 {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[3000000];
        queue.add(new int[]{x, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            if(cur[0]==y){
                return cur[1];
            }

            if(!visited[cur[0]+n]&&cur[0]+n<=y){
                queue.add(new int[]{cur[0]+n, cur[1]+1});
                visited[cur[0]+n]=true;
            }
            if(!visited[cur[0]*2]&&cur[0]*2<=y){
                queue.add(new int[]{cur[0]*2, cur[1]+1});
                visited[cur[0]*2]=true;
            }
            if(!visited[cur[0]*3]&&cur[0]*3<=y){
                queue.add(new int[]{cur[0]*3, cur[1]+1});
                visited[cur[0]*3]=true;
            }
        }

        return -1;
    }
}