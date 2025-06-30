import java.util.*;

public class PG_20250630_퍼즐_조각_채우기 {

    class Solution {

        private static final int[] dRow = { -1, 1, 0, 0 };
        private static final int[] dCol = { 0, 0, -1, 1 };

        public int solution(int[][] game_board, int[][] table) {
            Map<EqualBlockSet, Integer> equalBlockSetCnts = new HashMap<>();
            for (int row = 0; row < table.length; row++) {
                for (int col = 0; col < table[row].length; col++) {
                    if (table[row][col] != 1) {
                        continue;
                    }
                    Block block = bfs(table, row, col, 1, 0);
                    EqualBlockSet equalBlockSet = new EqualBlockSet(block);
                    equalBlockSetCnts.put(equalBlockSet, equalBlockSetCnts.getOrDefault(equalBlockSet, 0) + 1);
                }
            }
            int result = 0;
            for (int row = 0; row < game_board.length; row++) {
                for (int col = 0; col < game_board[row].length; col++) {
                    if (game_board[row][col] != 0) {
                        continue;
                    }
                    Block area = bfs(game_board, row, col, 0, 1);
                    for (Map.Entry<EqualBlockSet, Integer> entry : equalBlockSetCnts.entrySet()) {
                        if (!entry.getKey().contains(area)) {
                            continue;
                        }
                        if (entry.getValue().equals(0)) {
                            continue;
                        }
                        equalBlockSetCnts.put(entry.getKey(), entry.getValue() - 1);
                        result += area.size();
                    }
                }
            }
            return result;
        }

        private Block bfs(int[][] table, int row, int col, int target, int inverseTarget) {
            Queue<Point> queue = new ArrayDeque<>();
            queue.add(new Point(row, col));
            table[row][col] = inverseTarget;
            Set<Point> points = new HashSet<>();
            while (!queue.isEmpty()) {
                Point currentPoint = queue.remove();
                points.add(currentPoint);
                for (int direction = 0; direction < 4; direction++) {
                    int newRow = currentPoint.getRow() + dRow[direction];
                    int newCol = currentPoint.getCol() + dCol[direction];
                    if (!canVisit(table, newRow, newCol, target)) {
                        continue;
                    }
                    queue.add(new Point(newRow, newCol));
                    table[newRow][newCol] = inverseTarget;
                }
            }
            return new Block(points);
        }

        private boolean canVisit(int[][] table, int row, int col, int target) {
            return !isOutOfBounds(table, row, col) && table[row][col] == target;
        }

        private boolean isOutOfBounds(int[][] table, int row, int col) {
            return row < 0 || table.length <= row
                    || col < 0 || table[row].length <= col;
        }

        static class EqualBlockSet {

            private Set<Block> blockSet = new HashSet<>();

            public EqualBlockSet(Block block) {
                this.blockSet.add(block);
                Block rotatedBlock = block;
                for (int i = 0; i < 3; i++) {
                    rotatedBlock = rotatedBlock.rotate();
                    blockSet.add(rotatedBlock);
                }
            }

            public boolean contains(Block block) {
                return blockSet.contains(block);
            }

            @Override
            public boolean equals(Object o) {
                if (o == null) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                if (this.getClass() != o.getClass()) {
                    return false;
                }
                EqualBlockSet other = (EqualBlockSet) o;
                return this.blockSet.equals(other.blockSet);
            }

            @Override
            public int hashCode() {
                return this.blockSet.hashCode();
            }

        }

        static class Block {

            private Set<Point> points;

            public Block(Collection<Point> points) {
                this.points = scale(points);
            }

            private static Set<Point> scale(Collection<Point> points) {
                Set<Point> scaledPoints = new HashSet<>();
                int minRow = Integer.MAX_VALUE;
                int minCol = Integer.MAX_VALUE;
                for (Point point : points) {
                    if (point.getRow() < minRow) {
                        minRow = point.getRow();
                    }
                    if (point.getCol() < minCol) {
                        minCol = point.getCol();
                    }
                }
                for (Point point : points) {
                    scaledPoints.add(new Point(point.getRow() - minRow, point.getCol() - minCol));
                }
                return scaledPoints;
            }

            public Block rotate() {
                Set<Point> rotatedPoints = new HashSet<>();
                for (Point point : this.points) {
                    rotatedPoints.add(new Point(point.getCol(), -point.getRow()));
                }
                return new Block(rotatedPoints);
            }

            public int size() {
                return this.points.size();
            }

            @Override
            public boolean equals(Object o) {
                if (o == null) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                if (this.getClass() != o.getClass()) {
                    return false;
                }
                Block other = (Block) o;
                return this.points.equals(other.points);
            }

            @Override
            public int hashCode() {
                return this.points.hashCode();
            }

        }

        static class Point {

            private int row;
            private int col;

            public Point(int row, int col) {
                this.row = row;
                this.col = col;
            }

            public int getRow() {
                return this.row;
            }

            public int getCol() {
                return this.col;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                if (this.getClass() != o.getClass()) {
                    return false;
                }
                Point other = (Point) o;
                return this.row == other.row && this.col == other.col;
            }

            @Override
            public int hashCode() {
                return Objects.hash(this.row, this.col);
            }

        }

    }

}
