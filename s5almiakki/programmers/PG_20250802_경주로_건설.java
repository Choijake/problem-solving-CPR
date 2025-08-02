import java.util.*;

public class PG_20250802_경주로_건설 {

    class Solution {

        private int[] dRow = { -1, 0, 1, 0 };
        private int[] dColumn = { 0, 1, 0, -1 };

        public int solution(int[][] board) {
            // direction, row, column
            int[][][] costSums = new int[board.length][board[0].length][4];
            for (int[][] array : costSums) {
                for (int[] row : array) {
                    Arrays.fill(row, -1);
                }
            }
            Queue<RoadInfo> queue = new ArrayDeque<>();
            queue.add(new RoadInfo(0, 0, 1, 0));
            costSums[0][0][1] = 0;
            queue.add(new RoadInfo(0, 0, 2, 0));
            costSums[0][0][2] = 0;
            do {
                RoadInfo currentRoadInfo = queue.remove();
                if (currentRoadInfo.row == board.length - 1 && currentRoadInfo.column == board[0].length - 1) {
                    continue;
                }
                for (int direction = 0; direction < 4; direction++) {
                    if (Math.abs(currentRoadInfo.direction - direction) == 2) {
                        continue;
                    }
                    int nextRow = currentRoadInfo.row + dRow[direction];
                    int nextColumn = currentRoadInfo.column + dColumn[direction];
                    if (isOutOfBounds(nextRow, nextColumn, board.length, board[0].length)) {
                        continue;
                    }
                    if (board[nextRow][nextColumn] == 1) {
                        continue;
                    }
                    int nextCostSum = currentRoadInfo.costSum
                            + (direction == currentRoadInfo.direction ? 100 : 600);
                    int formerNextCostSum = costSums[nextRow][nextColumn][direction];
                    if (formerNextCostSum != -1 && formerNextCostSum <= nextCostSum) {
                        continue;
                    }
                    queue.add(new RoadInfo(nextRow, nextColumn, direction, nextCostSum));
                    costSums[nextRow][nextColumn][direction] = nextCostSum;
                }
            } while (!queue.isEmpty());
            int result = Integer.MAX_VALUE;
            for (int costSum : costSums[board.length - 1][board[0].length - 1]) {
                if (costSum != -1) {
                    result = Math.min(result, costSum);
                }
            }
            return result;
        }

        private boolean isOutOfBounds(int row, int column, int rowBound, int columnBound) {
            return row < 0 || rowBound <= row
                    || column < 0 || columnBound <= column;
        }

        static class RoadInfo {

            int row;
            int column;
            int direction;
            int costSum;

            public RoadInfo(int row, int column, int direction, int costSum) {
                this.row = row;
                this.column = column;
                this.direction = direction;
                this.costSum = costSum;
            }

        }

    }

}
