import java.util.*;

public class PG_20250830_외벽_점검 {

    class Solution {

        private int borderLength;
        private int[] weakPoints;
        private int[] visitedCnts;
        private int visitedPointCnt = 0;
        private int[] distances;
        private int answer = -1;

        private void init(int n, int[] weak, int[] dist) {
            borderLength = n;
            weakPoints = Arrays.copyOf(weak, weak.length);
            visitedCnts = new int[weakPoints.length];
            distances = Arrays.copyOf(dist, dist.length);
            Arrays.sort(distances);
            for (int i = 0; i < distances.length >> 1; i++) {
                int temp = distances[i];
                distances[i] = distances[dist.length - 1 - i];
                distances[distances.length - 1 - i] = temp;
            }
        }

        public int solution(int n, int[] weak, int[] dist) {
            init(n, weak, dist);
            backtrack(0);
            return answer;
        }

        private void backtrack(int distanceIdx) {
            if (visitedPointCnt == weakPoints.length) {
                if (answer == -1) {
                    answer = distanceIdx;
                } else {
                    answer = Math.min(answer, distanceIdx);
                }
                return;
            }
            if (distanceIdx == distances.length) {
                return;
            }
            for (int i = 0; i < weakPoints.length; i++) {
                if (visitedCnts[i] > 0) {
                    continue;
                }
                int startPoint = weakPoints[i];
                int endPoint = startPoint + distances[distanceIdx];
                for (int j = 0; j < weakPoints.length; j++) {
                    if (startPoint <= weakPoints[j] && weakPoints[j] <= endPoint
                            || startPoint - borderLength <= weakPoints[j] && weakPoints[j] <= endPoint - borderLength) {
                        if (visitedCnts[j] == 0) {
                            visitedPointCnt++;
                        }
                        visitedCnts[j]++;
                    }
                    if (endPoint < weakPoints[j]) {
                        break;
                    }
                }
                backtrack(distanceIdx + 1);
                for (int j = 0; j < weakPoints.length; j++) {
                    if (startPoint <= weakPoints[j] && weakPoints[j] <= endPoint
                            || startPoint - borderLength <= weakPoints[j] && weakPoints[j] <= endPoint - borderLength) {
                        visitedCnts[j]--;
                        if (visitedCnts[j] == 0) {
                            visitedPointCnt--;
                        }
                    }
                    if (endPoint < weakPoints[j]) {
                        break;
                    }
                }
            }
        }

    }

}
