import java.io.*;
import java.util.*;

public class PG_20250602_올바른괄호 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(stack.size() == 0) {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')') {
				if(stack.peek() == '(') {
					stack.pop();
				}else {
					stack.push(s.charAt(i));
				}
			}
		}
		
		if(stack.size() == 0) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		br.close();
	}
}
