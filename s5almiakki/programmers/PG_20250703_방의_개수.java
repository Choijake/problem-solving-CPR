import java.util.*;

public class PG_20250703_방의_개수 {

    class Solution {

        private final Point startPoint = new Point(0, 0);
        private Map<Point, Set<Point>> adjList = new HashMap<>();
        private Set<Point> visitedPoints = new HashSet<>();
        private Set<Diagonal> diagonals = new HashSet<>();
        private Set<Diagonal> checkedDiagonals = new HashSet<>();
        private int result = 0;

        public int solution(int[] arrows) {
            Point prevPoint = startPoint;
            for (int arrow : arrows) {
                Point currentPoint = prevPoint.move(Direction.values()[arrow]);
                if (adjList.get(prevPoint) == null) {
                    adjList.put(prevPoint, new HashSet<>());
                }
                if (adjList.get(currentPoint) == null) {
                    adjList.put(currentPoint, new HashSet<>());
                }
                adjList.get(prevPoint).add(currentPoint);
                adjList.get(currentPoint).add(prevPoint);
                prevPoint = currentPoint;
            }
            visitedPoints.add(startPoint);
            dfs(startPoint, null);
            return result / 2;
        }

        private void dfs(Point point, Point prevPoint) {
            for (Point adjPoint : adjList.get(point)) {
                if (adjPoint.equals(prevPoint)) {
                    continue;
                }
                if (Diagonal.isDiagonal(point, adjPoint)) {
                    Diagonal diagonal = new Diagonal(point, adjPoint);
                    diagonals.add(diagonal);
                    Diagonal flippedDiagonal = diagonal.flip();
                    if (diagonals.contains(flippedDiagonal)
                            && !checkedDiagonals.contains(diagonal)) {
                        result += 2;
                    }
                    checkedDiagonals.add(diagonal);
                }
                if (visitedPoints.contains(adjPoint)) {
                    result++;
                    continue;
                }
                visitedPoints.add(adjPoint);
                dfs(adjPoint, point);
            }
        }

        static enum Direction {

            UP(0, 1),
            UPPER_RIGHT(1, 1),
            RIGHT(1, 0),
            LOWER_RIGHT(1, -1),
            DOWN(0, -1),
            LOWER_LEFT(-1, -1),
            LEFT(-1, 0),
            UPPER_LEFT(-1, 1);

            private final int dx;
            private final int dy;

            Direction(int dx, int dy) {
                this.dx = dx;
                this.dy = dy;
            }

            public int getDx() {
                return this.dx;
            }

            public int getDy() {
                return this.dy;
            }

        }

        static class Point {

            private int x;
            private int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public Point move(Direction direction) {
                return new Point(this.x + direction.getDx(), this.y + direction.getDy());
            }

            public int getX() {
                return this.x;
            }

            public int getY() {
                return this.y;
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
                return this.x == other.x && this.y == other.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(this.x, this.y);
            }

            @Override
            public String toString() {
                return "Point[x=" + x + ", y=" + y + "]";
            }

        }

        static class Diagonal {

            private Set<Point> points = new HashSet<>();

            public Diagonal(Point point1, Point point2) {
                this.points.add(point1);
                this.points.add(point2);
            }

            public static boolean isDiagonal(Point point1, Point point2) {
                return Math.abs(point1.getX() - point2.getX()) == 1
                        && Math.abs(point1.getY() - point2.getY()) == 1;
            }

            public Diagonal flip() {
                List<Point> points = new ArrayList<>();
                for (Point point : this.points) {
                    points.add(point);
                }
                return new Diagonal(
                        new Point(points.get(0).getX(), points.get(1).getY()),
                        new Point(points.get(1).getX(), points.get(0).getY())
                        );
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
                Diagonal other = (Diagonal) o;
                return this.points.equals(other.points);
            }

            @Override
            public int hashCode() {
                return Objects.hash(points);
            }

            @Override
            public String toString() {
                return this.points.toString();
            }

        }

    }

}
