
public class PG_20250726_기지국_설치 {

    class Solution {

        public int solution(int n, int[] stations, int w) {
            int result = 0;
            int prevEnd = 0;
            int coverableRange = (w << 1) + 1;
            for (int station : stations) {
                int interval = station - w - prevEnd - 1;
                if (interval >= 1) {
                    result += (interval + coverableRange - 1) / coverableRange;
                }
                prevEnd = station + w;
            }
            int interval = n - prevEnd;
            if (interval >= 1) {
                result += (interval + coverableRange - 1) / coverableRange;
            }
            return result;
        }

    }

}
