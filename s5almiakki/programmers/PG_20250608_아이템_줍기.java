import java.util.*;

public class PG_20250608_아이템_줍기 {

    class Solution {

        private int[] dx = { -1, 1, 0, 0 };
        private int[] dy = { 0, 0, -1, 1 };

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            Point characterPoint = new Point(characterX, characterY);
            Point itemPoint = new Point(itemX, itemY);
            Queue<PathRecord> queue = new ArrayDeque<>();
            Set<Point> visitedPoints = new HashSet<>();
            queue.add(new PathRecord(characterPoint, 0));
            visitedPoints.add(characterPoint);
            while (true) {
                PathRecord currentPathRecord = queue.remove();
                Point currentPoint = currentPathRecord.getPoint();
                if (currentPoint.equals(itemPoint)) {
                    return currentPathRecord.getDistance();
                }
                for (int direction = 0; direction < 4; direction++) {
                    Point newPoint = new Point(
                            currentPoint.getX() + dx[direction],
                            currentPoint.getY() + dy[direction]
                    );
                    if (!isVisitable(visitedPoints, rectangle, currentPoint, newPoint)) {
                        continue;
                    }
                    queue.add(new PathRecord(newPoint, currentPathRecord.getDistance() + 1));
                    visitedPoints.add(newPoint);
                }
            }
        }

        private boolean isVisitable(
                Set<Point> visitedPoints,
                int[][] rectangles,
                Point previousPoint,
                Point point
        ) {
            if (visitedPoints.contains(point)) {
                return false;
            }
            for (int[] rectangle : rectangles) {
                if (isInside(previousPoint, point, rectangle)) {
                    return false;
                }
            }
            for (int[] rectangle : rectangles) {
                if (!isOutside(previousPoint, point, rectangle)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isInside(Point point1, Point point2, int[] rectangle) {
            Point middle = new Point(
                    (point1.getX() + point2.getX()) / 2,
                    (point1.getY() + point2.getY()) / 2
            );
            return rectangle[0] < middle.getX() && middle.getX() < rectangle[2]
                    && rectangle[1] < middle.getY() && middle.getY() < rectangle[3];
        }

        private boolean isOutside(Point point1, Point point2, int[] rectangle) {
            Point middle = new Point(
                    (point1.getX() + point2.getX()) / 2,
                    (point1.getY() + point2.getY()) / 2
            );
            return middle.getX() < rectangle[0] || rectangle[2] < middle.getX()
                    || middle.getY() < rectangle[1] || rectangle[3] < middle.getY();
        }

        private class PathRecord {

            private Point point;
            private int distance;

            public PathRecord(Point point, int distance) {
                this.point = point;
                this.distance = distance;
            }

            public Point getPoint() {
                return this.point;
            }

            public int getDistance() {
                return this.distance;
            }

        }

        private class Point {

            private float x;
            private float y;

            public Point(float x, float y) {
                this.x = x;
                this.y = y;
            }

            public float getX() {
                return this.x;
            }

            public float getY() {
                return this.y;
            }

            @Override
            public boolean equals(Object obj) {
                if (obj == null) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                if (this.getClass() != obj.getClass()) {
                    return false;
                }
                Point other = (Point) obj;
                return this.x == other.x && this.y == other.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

        }

    }

}
