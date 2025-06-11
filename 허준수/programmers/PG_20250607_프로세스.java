//PG_프로세스, Level2
//일단  location 위치와 priorites 가 함께 연결돼야함
// 우선순위 큐 써야하나? ㄴㄴ 우선순위큐 쓰면은 실행순서가 이상함
// 기존 큐 기능 써야할거같은데 이떄 location 정보를 함께 가지고 있어야함
// 그리고 중요도가 젤 높은게 있는지도 측정해야함

import java.io.*;
import java.util.*;

public class PG_20250607_프로세스 {
	
	class Solution {
		public class feature {
			int priority;
			int loc;
			
			public feature(int priority, int loc) {
				this.priority = priority;
				this.loc = loc;
			}
		}
		
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<feature> q = new LinkedList<>();
	        List<Integer> pList = new ArrayList<>();
	        
	        for(int p : priorities) {
	        	pList.add(p);
	        }
	        
	        pList.sort(Collections.reverseOrder());
	     
	        for(int i = 0; i < priorities.length; i++) {
	            q.add(new feature(priorities[i], i));
	        }
	        
	        while(!q.isEmpty()) {
	        	feature cur = q.poll();
	        	
	        	if(cur.priority == pList.get(0)) {
	        		answer++;
	        		
	        		if(cur.loc == location)
	        			break;
	        		pList.remove(0);
	        	}
	        	else {
	        		q.add(cur);
	        	}
	        }
	        
	        return answer;
	    }
	}
	
}
