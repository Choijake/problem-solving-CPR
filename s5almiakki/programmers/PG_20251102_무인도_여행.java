import java.util.*;

public class PG_20251102_무인도_여행 {

    class Solution {

        private static final int[] D_ROW = { -1, 1, 0, 0 };
        private static final int[] D_COL = { 0, 0, -1, 1 };

        public int[] solution(String[] maps) {
            Queue<int[]> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[maps.length][maps[0].length()];
            List<Integer> sums = new ArrayList<>();
            for (int row = 0; row < maps.length; row++) {
                for (int col = 0; col < maps[row].length(); col++) {
                    if (maps[row].charAt(col) == 'X'
                            || visited[row][col]) {
                        continue;
                    }
                    queue.add(new int[] { row, col });
                    visited[row][col] = true;
                    int sum = maps[row].charAt(col) - '0';
                    do {
                        int[] currentPoint = queue.remove();
                        for (int direction = 0; direction < 4; direction++) {
                            int newRow = currentPoint[0] + D_ROW[direction];
                            int newCol = currentPoint[1] + D_COL[direction];
                            if (isOutOfBounds(maps, newRow, newCol)
                                    || maps[newRow].charAt(newCol) == 'X'
                                    || visited[newRow][newCol]) {
                                continue;
                            }
                            queue.add(new int[] { newRow, newCol });
                            visited[newRow][newCol] = true;
                            sum += maps[newRow].charAt(newCol) - '0';
                        }
                    } while (!queue.isEmpty());
                    sums.add(sum);
                }
            }
            for (boolean[] row : visited) {
                System.out.println(Arrays.toString(row));
            }
            if (sums.isEmpty()) {
                return new int[] { -1 };
            }
            int[] answer = sums.stream().mapToInt(i -> i).toArray();
            Arrays.sort(answer);
            return answer;
        }

        private boolean isOutOfBounds(String[] maps, int row, int col) {
            return row < 0 || maps.length <= row
                    || col < 0 || maps[row].length() <= col;
        }

    }

}
