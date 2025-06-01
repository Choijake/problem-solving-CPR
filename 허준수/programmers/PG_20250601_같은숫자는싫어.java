import java.io.*;
import java.util.*;

public class PG_20250601_같은숫자는싫어 {
	public int[] solution(int []arr) {
		int [] answer = {};
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		
		int num = -1;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != num) {
				arr2.add(arr[i]);
				num = arr[i];
			}
		}
		
		answer = new int[arr2.size()];
		for(int i = 0; i < arr2.size(); i++) {
			answer[i] = arr2.get(i);
		}
		
		return answer;
	}
}
