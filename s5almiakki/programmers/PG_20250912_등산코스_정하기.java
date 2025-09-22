import java.util.*;

public class PG_20250912_등산코스_정하기 {

    class Solution {

        private int nodeCnt;
        private List<List<NodeWeight>> adjList = new ArrayList<>();
        private int[] gates;
        private int[] summits;
        private int[] intensities;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            init(n, paths, gates, summits);
            return solve();
        }

        private void init(int n, int[][] paths, int[] gates, int[] summits) {
            this.nodeCnt = n;
            for (int i = 0; i < n; i++) {
                this.adjList.add(new ArrayList<>());
            }
            for (int[] path : paths) {
                int node1 = path[0] - 1;
                int node2 = path[1] - 1;
                this.adjList.get(node1).add(new NodeWeight(node2, path[2]));
                this.adjList.get(node2).add(new NodeWeight(node1, path[2]));
            }

            this.gates = new int[gates.length];
            for (int i = 0; i < gates.length; i++) {
                this.gates[i] = gates[i] - 1;
            }
            Arrays.sort(this.gates);

            this.summits = new int[summits.length];
            for (int i = 0; i < summits.length; i++) {
                this.summits[i] = summits[i] - 1;
            }
            Arrays.sort(this.summits);

            this.intensities = new int[n];
            Arrays.fill(this.intensities, Integer.MAX_VALUE);
        }

        private int[] solve() {
            PriorityQueue<NodeWeight> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[nodeCnt];
            for (int gate : this.gates) {
                pq.add(new NodeWeight(gate, 0));
            }
            do {
                NodeWeight currentNodeWeight = pq.remove();
                if (Arrays.binarySearch(this.summits, currentNodeWeight.node) >= 0) {
                    continue;
                }
                if (visited[currentNodeWeight.node]
                        && this.intensities[currentNodeWeight.node] <= currentNodeWeight.weight) {
                    continue;
                }
                visited[currentNodeWeight.node] = true;
                this.intensities[currentNodeWeight.node] = currentNodeWeight.weight;
                for (NodeWeight adjNodeWeight : this.adjList.get(currentNodeWeight.node)) {
                    int newIntensity = Math.max(currentNodeWeight.weight, adjNodeWeight.weight);
                    if (this.intensities[adjNodeWeight.node] <= newIntensity) {
                        continue;
                    }
                    pq.add(new NodeWeight(adjNodeWeight.node, newIntensity));
                    visited[adjNodeWeight.node] = false;
                    this.intensities[adjNodeWeight.node] = newIntensity;
                }
            } while (!pq.isEmpty());
            int[] result = { -1, Integer.MAX_VALUE };
            for (int summit : this.summits) {
                if (intensities[summit] < result[1]) {
                    result[0] = summit;
                    result[1] = intensities[summit];
                }
            }
            result[0]++;
            return result;
        }

        private static class NodeWeight implements Comparable<NodeWeight> {

            int node;
            int weight;

            public NodeWeight(int node, int weight) {
                this.node = node;
                this.weight = weight;
            }

            @Override
            public int compareTo(NodeWeight o) {
                return this.weight - o.weight;
            }

            @Override
            public String toString() {
                return "[" + (node) + ", " + weight + "]";
            }

        }

    }

}
