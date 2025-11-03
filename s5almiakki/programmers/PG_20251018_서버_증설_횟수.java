import java.util.*;

public class PG_20251018_서버_증설_횟수 {

    class Solution {

        public int solution(int[] players, int m, int k) {
            int serverCnt = 1;
            // [0]: extraServerCnt, [1]: returnTime
            Queue<int[]> extraServerQueue = new ArrayDeque<>();
            int answer = 0;
            for (int time = 0; time < players.length; time++) {
                int[] extraServer = extraServerQueue.peek();
                if (extraServer != null && extraServer[1] == time) {
                    serverCnt -= extraServer[0];
                    extraServerQueue.remove();
                }
                int extraServerCnt = ((players[time]) / m) - serverCnt + 1;
                if (extraServerCnt > 0) {
                    extraServerQueue.add(new int[] { extraServerCnt, time + k });
                    serverCnt += extraServerCnt;
                    answer += extraServerCnt;
                }
            }
            return answer;
        }

    }

}
