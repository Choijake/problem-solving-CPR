import java.io.*;
import java.util.*;

public class PG_20250606_게임맵최단거리 {
	
	static class Solution {
	    static int[] dx = {0, 1, 0, -1}; //우 하 좌 상
	    static int[] dy = {1, 0, -1, 0};
	    static int[][] board;
	    public int solution(int[][] maps) {
	        int answer = 0;
	        int n = maps.length;
	        int m = maps[0].length;

	        board = new int[n][m];
	        
	        answer = bfs(maps, n, m);
	        
	        return answer;
	    }
	    
	    static int bfs(int[][] maps , int n, int m) {
	    	Queue<int[]> q = new LinkedList<>();
	    	q.add(new int[] {0, 0});
	    	board[0][0] = 1;
	    	
	    	while(!q.isEmpty()) {
	    		int[] cur = q.poll();
	    		int x = cur[0];
	    		int y = cur[1];
	    		
	    		for(int dir = 0; dir < 4; dir++) {
	    			int nx = x + dx[dir];
	    			int ny = y + dy[dir];
	    			
	    			if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
	    			if(maps[nx][ny] == 0) continue;
	    			if(board[nx][ny] == 0) {
	    				board[nx][ny] = board[x][y] + 1;
	    				q.add(new int[] {nx, ny});
	    				if(nx == n-1 && ny == m-1) {
	    					return board[nx][ny];
	    				}
	    			}
	    		}
	    	}
	    	
	    	return -1;
	    }
	    
	}
	
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] maps = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };

        int result = sol.solution(maps);
        System.out.println("\n최단거리: " + result);
    }
}
