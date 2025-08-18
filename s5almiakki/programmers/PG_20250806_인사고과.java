import java.util.*;

public class PG_20250806_인사고과 {

    class Solution {

        public int solution(int[][] scores) {
            int[] wanHoScore = scores[0];
            Arrays.sort(scores, (score1, score2) ->
                    score1[0] != score2[0] ? score2[0] - score1[0] : score1[1] - score2[1]);
            int answer = 1;
            int maxCoworkerRating = 0;
            for (int[] score : scores) {
                if (score[1] < maxCoworkerRating) {
                    if (score == wanHoScore) {
                        return -1;
                    }
                    continue;
                }
                maxCoworkerRating = score[1];
                if (score[0] + score[1] > wanHoScore[0] + wanHoScore[1]) {
                    answer++;
                }
            }
            return answer;
        }

    }

}
