
public class PG_20250727_스티커_모으기_2 {

    class Solution {

        public int solution(int sticker[]) {
            if (sticker.length == 1) {
                return sticker[0];
            }
            int[] lastExcludedDp = new int[sticker.length];
            lastExcludedDp[0] = sticker[0];
            lastExcludedDp[1] = Math.max(sticker[0], sticker[1]);
            for (int i = 2; i < sticker.length - 1; i++) {
                lastExcludedDp[i] = Math.max(sticker[i] + lastExcludedDp[i - 2], lastExcludedDp[i - 1]);
            }
            int[] lastIncludedDp = new int[sticker.length];
            lastIncludedDp[1] = sticker[1];
            for (int i = 2; i < sticker.length; i++) {
                lastIncludedDp[i] = Math.max(sticker[i] + lastIncludedDp[i - 2], lastIncludedDp[i - 1]);
            }
            return Math.max(lastExcludedDp[sticker.length - 2], lastIncludedDp[sticker.length - 1]);
        }

    }

}
