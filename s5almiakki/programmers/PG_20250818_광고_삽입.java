
public class PG_20250818_광고_삽입 {

    class Solution {

        private int videoDuration;
        private int adDuration;
        private int[][] watchTimes;

        private void init(String play_time, String adv_time, String[] logs) {
            this.videoDuration = toIntTime(play_time.split(":"));
            this.adDuration = toIntTime(adv_time.split(":"));
            this.watchTimes = new int[logs.length][2];
            for (int i = 0; i < logs.length; i++) {
                String[] hmss = logs[i].split("-");
                watchTimes[i][0] = toIntTime(hmss[0].split(":"));
                watchTimes[i][1] = toIntTime(hmss[1].split(":"));
            }
        }

        public String solution(String play_time, String adv_time, String[] logs) {
            init(play_time, adv_time, logs);
            long[] accumulation = new long[videoDuration + 2];
            for (int[] watchTime : watchTimes) {
                accumulation[watchTime[0] + 1]++;
                accumulation[watchTime[1] + 1]--;
            }
            for (int i = 1; i < accumulation.length; i++) {
                accumulation[i] += accumulation[i - 1];
            }
            for (int i = 1; i < accumulation.length; i++) {
                accumulation[i] += accumulation[i - 1];
            }
            long maxAccumulation = 0;
            int answer = 0;
            for (int i = 0; i + adDuration < accumulation.length; i++) {
                long currentAccumulation = accumulation[i + adDuration] - accumulation[i];
                if (maxAccumulation < currentAccumulation) {
                    maxAccumulation = currentAccumulation;
                    answer = i;
                }
            }
            return toStringTime(answer);
        }

        private int toIntTime(String[] hms) {
            return toIntTime(hms[0], hms[1], hms[2]);
        }

        private int toIntTime(String h, String m, String s) {
            return Integer.parseInt(s)
                    + Integer.parseInt(m) * 60
                    + Integer.parseInt(h) * 3600;
        }

        private String toStringTime(int time) {
            return new StringBuilder()
                    .append(String.format("%02d", time / 3600)).append(':')
                    .append(String.format("%02d", (time % 3600) / 60)).append(':')
                    .append(String.format("%02d", time % 60)).toString();
        }

    }

}
