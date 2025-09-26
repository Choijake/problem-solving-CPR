import java.util.*;

class PG_전력망둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int node = wires[i][1];
            int count = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[n + 1];
            queue.add(node);
            visited[node] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int j = 0; j < wires.length; j++) {
                    if (i == j) continue;

                    if (wires[j][0] == cur && !visited[wires[j][1]]) {
                        count++;
                        queue.add(wires[j][1]);
                        visited[wires[j][1]] = true;
                    } else if (wires[j][1] == cur && !visited[wires[j][0]]) {
                        count++;
                        queue.add(wires[j][0]);
                        visited[wires[j][0]] = true;
                    }
                }
            }

            answer = Math.min(answer, Math.abs(count - (n - count)));
            System.out.println(count + ", " + (n - count) + ", " + (count - (n - count)));
        }

        return answer;
    }
}