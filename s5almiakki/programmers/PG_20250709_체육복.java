import java.util.*;

public class PG_20250709_체육복 {

    class Solution {

        public int solution(int n, int[] lost, int[] reserve) {
            int[] clothesCnts = new int[n];
            Arrays.fill(clothesCnts, 1);
            for (int student : lost) {
                clothesCnts[student - 1]--;
            }
            for (int student : reserve) {
                clothesCnts[student - 1]++;
            }
            if (clothesCnts[0] == 0 && clothesCnts[1] == 2) {
                clothesCnts[0]++;
                clothesCnts[1]--;
            }
            for (int student = 1; student < n - 1; student++) {
                if (clothesCnts[student] > 0) {
                    continue;
                }
                if (clothesCnts[student - 1] == 2) {
                    clothesCnts[student]++;
                    clothesCnts[student - 1]--;
                    continue;
                }
                if (clothesCnts[student + 1] == 2) {
                    clothesCnts[student]++;
                    clothesCnts[student + 1]--;
                }
            }
            if (clothesCnts[n - 1] == 0 && clothesCnts[n - 2] == 2) {
                clothesCnts[n - 1]++;
                clothesCnts[n - 2]--;
            }
            int result = n;
            for (int clothesCnt : clothesCnts) {
                if (clothesCnt == 0) {
                    result--;
                }
            }
            return result;
        }

    }

}
