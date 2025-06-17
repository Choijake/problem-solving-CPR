import java.util.*;

public class PG_20250611_여행경로 {

    class Solution {

        private int ticketCnt;
        private Map<String, List<AdjCity>> adjList = new HashMap<>();
        private List<String> visitedCities = new ArrayList<>();
        private String[] result = null;

        public String[] solution(String[][] tickets) {
            this.ticketCnt = tickets.length;
            for (String[] ticket : tickets) {
                if (adjList.get(ticket[0]) == null) {
                    adjList.put(ticket[0], new ArrayList<>());
                }
                adjList.get(ticket[0]).add(new AdjCity(ticket[1], false));
            }
            for (Map.Entry<String, List<AdjCity>> entry : adjList.entrySet()) {
                entry.getValue().sort(null);
            }
            visitedCities.add("ICN");
            dfs("ICN");
            return result;
        }

        private void dfs(String currentCity) {
            if (result != null) {
                return;
            }
            if (visitedCities.size() == ticketCnt + 1) {
                result = visitedCities.toArray(new String[0]);
                return;
            }
            List<AdjCity> adjCities = adjList.get(currentCity);
            if (adjCities == null) {
                return;
            }
            for (AdjCity adjCity : adjCities) {
                if (adjCity.visited) {
                    continue;
                }
                visitedCities.add(adjCity.to);
                adjCity.visited = true;
                dfs(adjCity.to);
                visitedCities.remove(visitedCities.size() - 1);
                adjCity.visited = false;
            }
        }

        class AdjCity implements Comparable<AdjCity> {

            String to;
            boolean visited;

            AdjCity(String to, boolean visited) {
                this.to = to;
                this.visited = visited;
            }

            @Override
            public int compareTo(AdjCity other) {
                return to.compareTo(other.to);
            }

        }

    }

}
