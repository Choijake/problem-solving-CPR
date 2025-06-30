import java.util.*;

public class PG_20250604_H_Index {

    class Solution {

        public int solution1(int[] citations) {
            Arrays.sort(citations);
            int high = citations[citations.length - 1];
            int low = 0;
            while (true) {
                int hArticleCnt = 0;
                if (high == low) {
                    return high;
                } else if (high - low == 1) {
                    for (int citation : citations) {
                        if (citation >= high) {
                            hArticleCnt++;
                        }
                    }
                    return hArticleCnt < high ? low : high;
                }
                int h = (high + low) >> 1;
                for (int i = citations.length - 1; i >= 0; i--) {
                    if (citations[i] < h) {
                        break;
                    }
                    if (citations[i] >= h) {
                        hArticleCnt++;
                    }
                }
                if (hArticleCnt < h) {
                    high = h;
                } else {
                    low = h;
                }
            }
        }

        public int solution2(int[] citations) {
            Arrays.sort(citations);
            int answer = 0;
            for (int i = citations.length - 1; i >= 0; i--) {
                int articleCnt = citations.length - i;
                int h = Math.min(articleCnt, citations[i]);
                if (answer < h) {
                    answer = h;
                }
            }
            return answer;
        }

    }

}
