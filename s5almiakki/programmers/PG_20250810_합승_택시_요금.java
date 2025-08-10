import java.util.*;

public class PG_20250810_합승_택시_요금 {

    class Solution {

        private int nodeCnt;
        private int startNode;
        private int destinationA;
        private int destinationB;
        private int[][] adjMat;

        private void init(int n, int s, int a, int b, int[][] fares) {
            this.nodeCnt = n;
            this.startNode = s - 1;
            this.destinationA = a - 1;
            this.destinationB = b - 1;
            this.adjMat = new int[this.nodeCnt][this.nodeCnt];
            for (int[] row : this.adjMat) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int node = 0; node < nodeCnt; node++) {
                adjMat[node][node] = 0;
            }
            for (int[] fare : fares) {
                this.adjMat[fare[0] - 1][fare[1] - 1] = fare[2];
                this.adjMat[fare[1] - 1][fare[0] - 1] = fare[2];
            }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            init(n, s, a, b, fares);
            for (int midNode = 0; midNode < this.nodeCnt; midNode++) {
                for (int node1 = 0; node1 < this.nodeCnt; node1++) {
                    for (int node2 = 0; node2 < this.nodeCnt; node2++) {
                        if (adjMat[node1][midNode] == Integer.MAX_VALUE || adjMat[midNode][node2] == Integer.MAX_VALUE) {
                            continue;
                        }
                        int newDistance = adjMat[node1][midNode] + adjMat[midNode][node2];
                        if (newDistance < adjMat[node1][node2]) {
                            adjMat[node1][node2] = newDistance;
                            adjMat[node2][node1] = newDistance;
                        }
                    }
                }
            }
            int answer = Integer.MAX_VALUE;
            for (int midNode = 0; midNode < this.nodeCnt; midNode++) {
                int d1 = this.adjMat[startNode][midNode];
                if (d1 == Integer.MAX_VALUE) {
                    continue;
                }
                int d2 = this.adjMat[midNode][destinationA];
                if (d2 == Integer.MAX_VALUE) {
                    continue;
                }
                int d3 = this.adjMat[midNode][destinationB];
                if (d3 == Integer.MAX_VALUE) {
                    continue;
                }
                answer = Math.min(answer, d1 + d2 + d3);
            }
            return answer;
        }

    }

}
