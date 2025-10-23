import java.util.*;

public class PG_20251023_블록_이동하기 {

    class Solution {

        public int solution(int[][] board) {
            Point targetPoint = new Point(board.length - 1, board[board.length - 1].length - 1);
            int answer = Integer.MAX_VALUE;
            Robot robot = new Robot(new Point(0, 0), new Point(0, 1));
            Queue<Robot> queue = new ArrayDeque<>();
            int[][][] movementCnts = new int[2][board.length][board[0].length];
            for (int[][] mc : movementCnts) {
                for (int[] row : mc) {
                    Arrays.fill(row, Integer.MAX_VALUE);
                }
            }
            queue.add(robot);
            movementCnts[0][0][0] = 0;
            do {
                Robot currentRobot = queue.remove();
                // for (int row = 0; row < movementCnts[0].length; row++) {
                //     for (int d = 0; d < movementCnts.length; d++) {
                //         for (int col = 0; col < movementCnts[0][0].length; col++) {
                //             System.out.print(movementCnts[d][row][col] == Integer.MAX_VALUE ? -1 : movementCnts[d][row][col]);
                //             System.out.print(", ");
                //         }
                //         System.out.print("  ");
                //     }
                //     System.out.println();
                // }
                // System.out.println(currentRobot);
                // move
                // System.out.println("  - move");
                for (Direction direction : Direction.values()) {
                    if (direction.equals(Direction.UP_LEFT)) {
                        break;
                    }
                    // System.out.println("  " + direction.name());
                    Robot newRobot = currentRobot.move(direction);
                    if (!canGo(board, newRobot)) {
                        continue;
                    }
                    if (newRobot.contains(targetPoint)) {
                        answer = Math.min(answer, newRobot.movementCnt);
                        continue;
                    }
                    Point firstPoint = newRobot.points.first();
                    int horizontalIdx = newRobot.isHorizontal() ? 0 : 1;
                    if (movementCnts[horizontalIdx][firstPoint.row][firstPoint.col] <= newRobot.movementCnt) {
                        continue;
                    }
                    // System.out.println("  " + newRobot);
                    queue.add(newRobot);
                    movementCnts[horizontalIdx][firstPoint.row][firstPoint.col] = newRobot.movementCnt;
                }
                // rotate clockwise
                // System.out.println("  - clockwise");
                for (Point fixedPoint : currentRobot.points) {
                    // System.out.println("  fixed=" + fixedPoint);
                    Robot newRobot = rotateClockwise(board, currentRobot, fixedPoint);
                    if (newRobot == null) {
                        // System.out.println("  cannot rotate");
                        continue;
                    }
                    if (newRobot.contains(targetPoint)) {
                        answer = Math.min(answer, newRobot.movementCnt);
                        continue;
                    }
                    Point firstPoint = newRobot.points.first();
                    int horizontalIdx = newRobot.isHorizontal() ? 0 : 1;
                    if (movementCnts[horizontalIdx][firstPoint.row][firstPoint.col] <= newRobot.movementCnt) {
                        // System.out.println("  moved too much");
                        continue;
                    }
                    // System.out.println("  " + newRobot);
                    queue.add(newRobot);
                    movementCnts[horizontalIdx][firstPoint.row][firstPoint.col] = newRobot.movementCnt;
                }
                // rotate counter-clockwise
                // System.out.println("  - counter-clockwise");
                for (Point fixedPoint : currentRobot.points) {
                    // System.out.println("  fixed=" + fixedPoint);
                    Robot newRobot = rotateCounterClockwise(board, currentRobot, fixedPoint);
                    if (newRobot == null) {
                        // System.out.println("  cannot rotate");
                        continue;
                    }
                    if (newRobot.contains(targetPoint)) {
                        answer = Math.min(answer, newRobot.movementCnt);
                        continue;
                    }
                    Point firstPoint = newRobot.points.first();
                    int horizontalIdx = newRobot.isHorizontal() ? 0 : 1;
                    if (movementCnts[horizontalIdx][firstPoint.row][firstPoint.col] <= newRobot.movementCnt) {
                        // System.out.println("  moved too much");
                        continue;
                    }
                    // System.out.println("  " + newRobot);
                    queue.add(newRobot);
                    movementCnts[horizontalIdx][firstPoint.row][firstPoint.col] = newRobot.movementCnt;
                }
            } while(!queue.isEmpty());
            return (answer == Integer.MAX_VALUE) ? -1 : answer;
        }

        private Robot rotateClockwise(int[][] board, Robot robot, Point fixedPoint) {
            Point otherPoint = robot.getOtherPoint(fixedPoint);
            Point dPoint = otherPoint.substract(fixedPoint);
            Point newDPoint = Direction.from(dPoint).rotateClockwise45().point;
            Point halfRotatedPoint = fixedPoint.add(newDPoint);
            if (isOutOfBounds(board, halfRotatedPoint)
                    || board[halfRotatedPoint.row][halfRotatedPoint.col] == 1) {
                return null;
            }
            newDPoint = Direction.from(dPoint).rotateClockwise().point;
            Point newOtherPoint = fixedPoint.add(newDPoint);
            if (board[newOtherPoint.row][newOtherPoint.col] == 1) {
                return null;
            }
            return new Robot(fixedPoint, newOtherPoint, robot.movementCnt + 1);
        }

        private Robot rotateCounterClockwise(int[][] board, Robot robot, Point fixedPoint) {
            Point otherPoint = robot.getOtherPoint(fixedPoint);
            Point dPoint = otherPoint.substract(fixedPoint);
            Point newDPoint = Direction.from(dPoint).rotateCounterClockwise45().point;
            Point halfRotatedPoint = fixedPoint.add(newDPoint);
            if (isOutOfBounds(board, halfRotatedPoint)
                    || board[halfRotatedPoint.row][halfRotatedPoint.col] == 1) {
                return null;
            }
            newDPoint = Direction.from(dPoint).rotateCounterClockwise().point;
            Point newOtherPoint = fixedPoint.add(newDPoint);
            if (board[newOtherPoint.row][newOtherPoint.col] == 1) {
                return null;
            }
            return new Robot(fixedPoint, newOtherPoint, robot.movementCnt + 1);
        }

        private boolean canGo(int[][] board, Robot robot) {
            for (Point point : robot.points) {
                if (isOutOfBounds(board, point) || board[point.row][point.col] == 1) {
                    return false;
                }
            }
            return true;
        }

        private boolean isOutOfBounds(int[][] board, Point point) {
            return point.row < 0 || board.length <= point.row
                    || point.col < 0 || board[point.row].length <= point.col;
        }

        private static class Robot {

            final SortedSet<Point> points = new TreeSet<>();
            final int movementCnt;

            public Robot(Point point1, Point point2) {
                this(point1, point2, 0);
            }

            public Robot(Point point1, Point point2, int movementCnt) {
                points.add(point1);
                points.add(point2);
                this.movementCnt = movementCnt;
            }

            public boolean isHorizontal() {
                return points.first().row == points.last().row;
            }

            public boolean contains(Point point) {
                return points.contains(point);
            }

            public Robot move(Direction direction) {
                Point point1 = points.first().add(direction);
                Point point2 = points.last().add(direction);
                return new Robot(point1, point2, movementCnt + 1);
            }

            public Robot rotateClockwise(Point fixedPoint) {
                Point dPoint = getOtherPoint(fixedPoint).substract(fixedPoint);
                Point rotatedDPoint = Direction.from(dPoint).rotateClockwise().point;
                return new Robot(fixedPoint, fixedPoint.add(rotatedDPoint), movementCnt + 1);
            }

            public Robot rotateCounterClockwise(Point fixedPoint) {
                Point dPoint = getOtherPoint(fixedPoint).substract(fixedPoint);
                Point rotatedDPoint = Direction.from(dPoint).rotateCounterClockwise().point;
                return new Robot(fixedPoint, fixedPoint.add(rotatedDPoint), movementCnt + 1);
            }

            public Point getOtherPoint(Point point) {
                return (points.first().equals(point)) ? points.last() : points.first();
            }

            @Override
            public String toString() {
                return "{" + points.toString() + ", " + movementCnt + "}";
            }

        }

        private static class Point implements Comparable<Point> {

            final int row;
            final int col;

            public Point(int row, int col) {
                this.row = row;
                this.col = col;
            }

            public Point add(Point other) {
                return new Point(this.row + other.row, this.col + other.col);
            }

            public Point substract(Point other) {
                return new Point(this.row - other.row, this.col - other.col);
            }

            public Point add(Direction direction) {
                return add(direction.point);
            }

            @Override
            public int compareTo(Point o) {
                if (this.row != o.row) {
                    return this.row - o.row;
                }
                return this.col - o.col;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Point)) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                Point other = (Point) o;
                return this.row == other.row && this.col == other.col;
            }

            @Override
            public int hashCode() {
                return Objects.hash(row, col);
            }

            @Override
            public String toString() {
                return "(" + row + "," + col + ")";
            }

        }

        private static enum Direction {

            UP(new Point(-1, 0)),
            RIGHT(new Point(0, 1)),
            DOWN(new Point(1, 0)),
            LEFT(new Point(0, -1)),

            UP_LEFT(new Point(-1, -1)),
            UP_RIGHT(new Point(-1, 1)),
            DOWN_RIGHT(new Point(1, 1)),
            DOWN_LEFT(new Point(1, -1));

            final Point point;

            private Direction(Point point) {
                this.point = point;
            }

            Direction rotateClockwise() {
                int nextOrdinal = (ordinal() + 1) % 4;
                if (ordinal() >= 4) {
                    nextOrdinal += 4;
                }
                return values()[nextOrdinal];
            }

            Direction rotateCounterClockwise() {
                int nextOrdinal = (ordinal() + 3) % 4;
                if (ordinal() >= 4) {
                    nextOrdinal += 4;
                }
                return values()[nextOrdinal];
            }

            Direction rotateClockwise45() {
                if (this.equals(LEFT)) {
                    return UP_LEFT;
                }
                return values()[ordinal() + 5];
            }

            Direction rotateCounterClockwise45() {
                return values()[ordinal() + 4];
            }

            static Direction from(Point point) {
                for (Direction direction : Direction.values()) {
                    if (point.equals(direction.point)) {
                        return direction;
                    }
                }
                return null;
            }

        }

    }

}
