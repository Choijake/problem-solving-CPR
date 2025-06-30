import java.io.*;
import java.util.*;

public class PG_20250605_최소직사각형 {
	
	class Solution {
	    public int solution(int[][] sizes) {
	        int answer = 0;
	        
	        int width = 0;
	        int height = 0;
	        
	        for(int i = 0; i < sizes.length; i++) {
	        	if(sizes[i][0] > sizes[i][1]) {
	        		width = (width > sizes[i][0]) ? width : sizes[i][0];
	        		height = (height > sizes[i][1]) ? height : sizes[i][1];
	        	}
	        	else {
	        		width = (width > sizes[i][1]) ? width : sizes[i][1];
	        		height = (height > sizes[i][0]) ? height : sizes[i][0];
	        	}
	        }
	        
	        answer = width * height;
	        return answer;
	    }
	}
	
}
