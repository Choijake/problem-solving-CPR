import java.io.*;
import java.util.*;

public class PG_20250604_네트워크 {
	
	class Solution {
		static boolean[] visit;
	    public int solution(int n, int[][] computers) {
	        int answer = 0;
	        visit = new boolean[n];
	        
	        for(int i = 0; i < n; i++) {
	        	if(!visit[i]) {
	        		func(n, computers, i);
	        		answer++;
	        	}
	        }
	      
	        
	        return answer;
	    }
	    
	    static void func(int n, int[][] computers, int vertex) {
	    	visit[vertex] = true;
	    	
	    	for(int i = 0; i < n; i++) {
	    		if(i == vertex) continue; 
	    		if(visit[i]) continue;
	    		
	    		if(computers[vertex][i] == 1) {
	    			visit[i] = true;
	    			func(n, computers, i);
	    		}
	    	}
	    	
	    	return;
	    }
	}
	
}
