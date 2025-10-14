
public class PG_20251014_호텔_대실 {

    class Solution {

        private static final int MAX_TIME = 24 * 60 + 10;

        public int solution(String[][] book_time) {
            int[] accumulations = new int[MAX_TIME];
            for (String[] bookTime : book_time) {
                int startTime = toIntTime(bookTime[0]);
                int endTime = toIntTime(bookTime[1]) + 10;
                accumulations[startTime]++;
                accumulations[endTime]--;
            }
            int answer = 0;
            for (int i = 1; i < accumulations.length; i++) {
                accumulations[i] += accumulations[i - 1];
                answer = Math.max(answer, accumulations[i]);
            }
            return answer;
        }

        private int toIntTime(String time) {
            return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
        }

    }

}
