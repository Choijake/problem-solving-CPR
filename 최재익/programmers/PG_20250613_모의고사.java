import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<int[]> patterns = new ArrayList<>();
        patterns.add(new int[]{1, 2, 3, 4, 5});
        patterns.add(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        patterns.add(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < patterns.size(); i++) {
            int[] p = patterns.get(i);
            int score = 0;


            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == p[j % p.length]) {
                    score++;
                }
            }
            result.add(new int[]{i + 1, score});
        }

        Collections.sort(result, (a, b) -> b[1] - a[1]);

        int max = result.get(0)[1];
        List<Integer> answer = new ArrayList<>();
        for (int[] r : result) {
            if (max == r[1]) {
                answer.add(r[0]);
            }
        }

        Collections.sort(answer);

        return answer;
    }
}