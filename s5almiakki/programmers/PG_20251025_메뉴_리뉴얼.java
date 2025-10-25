import java.util.*;

public class PG_20251025_메뉴_리뉴얼 {

    class Solution {

        private boolean[] courseLengthPresent = new boolean[11];
        private Map<String, Integer> combinationToCountMap = new HashMap<>();

        public String[] solution(String[] orders, int[] course) {
            for (int c : course) {
                courseLengthPresent[c] = true;
            }
            StringBuilder selectedMenus = new StringBuilder();
            for (String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                dfs(menus, selectedMenus, 0);
            }
            int[] maxCountsPerLength = new int[11];
            for (Map.Entry<String, Integer> entry : combinationToCountMap.entrySet()) {
                String s = entry.getKey();
                maxCountsPerLength[s.length()] = Math.max(maxCountsPerLength[s.length()], entry.getValue());
            }
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : combinationToCountMap.entrySet()) {
                String s = entry.getKey();
                if (entry.getValue() < Math.max(2, maxCountsPerLength[s.length()])) {
                    continue;
                }
                result.add(s);
            }
            result.sort(null);
            return result.toArray(new String[0]);
        }

        private void dfs(char[] menus, StringBuilder selectedMenus, int idx) {
            if (courseLengthPresent[selectedMenus.length()]) {
                String s = selectedMenus.toString();
                combinationToCountMap.put(s, combinationToCountMap.getOrDefault(s, 0) + 1);
            }
            for (int i = idx; i < menus.length; i++) {
                selectedMenus.append(menus[i]);
                dfs(menus, selectedMenus, i + 1);
                selectedMenus.deleteCharAt(selectedMenus.length() - 1);
            }
        }

    }

}
