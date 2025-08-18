import java.util.*;

public class PG_20250812_표_편집 {

    class Solution {

        private NavigableSet<Integer> remainingRows = new TreeSet<>();
        private int cursor;

        private void init(int n, int k) {
            for (int row = 0; row < n; row++) {
                remainingRows.add(row);
            }
            this.cursor = k;
        }

        public String solution(int n, int k, String[] cmd) {
            init(n, k);
            Deque<Integer> removalHistory = new ArrayDeque<>();
            for (String command : cmd) {
                String[] splittedCommand = command.split(" ");
                switch (splittedCommand[0]) {
                    case "U":
                        for (int i = 0; i < Integer.parseInt(splittedCommand[1]); i++) {
                            cursor = remainingRows.lower(cursor);
                        }
                        break;
                    case "D":
                        for (int i = 0; i < Integer.parseInt(splittedCommand[1]); i++) {
                            cursor = remainingRows.higher(cursor);
                        }
                        break;
                    case "C":
                        remainingRows.remove(cursor);
                        removalHistory.push(cursor);
                        int highest = remainingRows.last();
                        cursor = (highest < cursor) ? highest : remainingRows.higher(cursor);
                        break;
                    case "Z":
                        remainingRows.add(removalHistory.remove());
                        break;
                }
            }
            StringBuilder result = new StringBuilder();
            for (int row = 0; row < n; row++) {
                result.append(remainingRows.contains(row) ? 'O' : 'X');
            }
            return result.toString();
        }

    }

}
