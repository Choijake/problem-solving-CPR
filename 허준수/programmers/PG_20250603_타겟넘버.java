import java.io.*;
import java.util.*;

public class PG_20250603_타겟넘버 {
	
	class Solution {
		static int answer = 0;
		
	    public int solution(int[] numbers, int target) {
	        int size = numbers.length;
	        dfs(numbers, target, size, 0, 0);
	        
	        return answer;
	    }
	    
	    static void dfs(int[] numbers, int target, int size, int idx, int total) {
        	if(idx == size) {
        		if(total == target) {
        			answer++;
        		}
        		return;
        	}
        	
    		dfs(numbers, target, size, idx+1, total + numbers[idx]);
    		dfs(numbers, target, size, idx+1, total - numbers[idx]);
        	
        }
	}
	
}
