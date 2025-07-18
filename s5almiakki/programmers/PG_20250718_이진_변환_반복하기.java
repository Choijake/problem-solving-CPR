
public class PG_20250718_이진_변환_반복하기 {

    class Solution {

        public int[] solution(String s) {
            int conversionCnt = 0;
            int removalCnt = 0;
            while (s.length() != 1) {
                char[] bits = s.toCharArray();
                int oneCnt = 0;
                for (char bit : bits) {
                    switch (bit) {
                        case '0':
                            removalCnt++;
                            break;
                        case '1':
                            oneCnt++;
                            break;
                    }
                }
                s = Integer.toBinaryString(oneCnt);
                conversionCnt++;
            }
            return new int[] { conversionCnt, removalCnt };
        }

    }

}
