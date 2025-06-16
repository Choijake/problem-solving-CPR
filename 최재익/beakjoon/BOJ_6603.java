import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    private static int k;
    private static int[] set;
    private static int[] result;
    private static final int SIZE = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while(true){
            line = br.readLine();

            if(line == null || line.isEmpty() || line.equals("0")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);

            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            set = new int[k];
            for(int i=0; i<set.length; i++){
                set[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[SIZE];

            combination(0, 0);
            System.out.println();
        }

        br.close();
    }

    public static void combination(int depth, int start){
        if(depth==SIZE){
            for(int i : result){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i=start; i<k; i++){
            result[depth] = set[i];
            combination(depth+1, i+1);
        }
    }
}
/**
 * System.in은 표준 입력 스트림으로, 일반적으로 한 번만 열어서 사용하는 것이 일반적입니다.
 * 루프 안에서 계속 새로운 BufferedReader를 생성하여 System.in에 연결하려고 하면 문제가 발생할 수 있습니다.
 * 특히, System.in 스트림은 한 번 닫히면 더 이상 읽을 수 없게 됩니다.
 * JVM이 System.in 스트림을 한 번 닫아버리면, 이후에 아무리 새로운 BufferedReader 객체를 생성하더라도 System.in으로부터 읽어올 수 없게 됩니다.
 * 비록 코드에 명시적으로 br.close()가 없지만, 프로그램의 특정 상황(예: JVM 내부적인 처리, OS 레벨에서의 스트림 관리 등)에 따라 System.in이 닫히거나 유효하지 않은 상태가 될 수 있습니다.
 */