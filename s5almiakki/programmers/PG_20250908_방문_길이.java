import java.util.*;

public class PG_20250908_방문_길이 {

    class Solution {

        public int solution(String dirs) {
            int answer = 0;
            Set<Line> visitedLines = new HashSet<>();
            Point currentPoint = new Point(0, 0);
            for (char direction : dirs.toCharArray()) {
                Point nextPoint = null;
                switch (direction) {
                    case 'U':
                        nextPoint = new Point(currentPoint.x, currentPoint.y + 1);
                        break;
                    case 'D':
                        nextPoint = new Point(currentPoint.x, currentPoint.y - 1);
                        break;
                    case 'R':
                        nextPoint = new Point(currentPoint.x + 1, currentPoint.y);
                        break;
                    case 'L':
                        nextPoint = new Point(currentPoint.x - 1, currentPoint.y);
                        break;
                }
                if (isOutOfBounds(nextPoint)) {
                    continue;
                }
                Line newLine = new Line(currentPoint, nextPoint);
                if (visitedLines.add(newLine)) {
                    answer++;
                }
                currentPoint = nextPoint;
            }
            return answer;
        }

        private boolean isOutOfBounds(Point point) {
            return point.x < -5 || 5 < point.x
                    || point.y < -5 || 5 < point.y;
        }

        private static class Line {

            Set<Point> points = new HashSet<>();

            public Line(Point point1, Point point2) {
                points.add(point1);
                points.add(point2);
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || this.getClass() != o.getClass()) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                Line other = (Line) o;
                return this.points.equals(other.points);
            }

            @Override
            public int hashCode() {
                return points.hashCode();
            }

        }

        private static class Point {

            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null || this.getClass() != o.getClass()) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                Point other = (Point) o;
                return this.x == other.x && this.y == other.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

        }

    }

}
