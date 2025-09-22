import java.util.*;

public class PG_20250905_1차_뉴스_클러스터링 {

    class Solution {

        private static final int CONSTANT = 65_536;

        public int solution(String str1, String str2) {
            str1 = str1.toLowerCase();
            Map<String, Integer> map1 = new HashMap<>();
            for (int i = 0; i < str1.length() - 1; i++) {
                char c1 = str1.charAt(i);
                if (c1 < 'a' || 'z' < c1) {
                    continue;
                }
                char c2 = str1.charAt(i + 1);
                if (c2 < 'a' || 'z' < c2) {
                    continue;
                }
                String element = "" + c1 + c2;
                map1.put(element, map1.getOrDefault(element, 0) + 1);
            }
            str2 = str2.toLowerCase();
            Map<String, Integer> map2 = new HashMap<>();
            Map<String, Integer> intersectionMap = new HashMap<>();
            for (int i = 0; i < str2.length() - 1; i++) {
                char c1 = str2.charAt(i);
                if (c1 < 'a' || 'z' < c1) {
                    continue;
                }
                char c2 = str2.charAt(i + 1);
                if (c2 < 'a' || 'z' < c2) {
                    continue;
                }
                String element = "" + c1 + c2;
                map2.put(element, map2.getOrDefault(element, 0) + 1);
                if (map1.containsKey(element) && map1.get(element) > intersectionMap.getOrDefault(element, 0)) {
                    intersectionMap.put(element, intersectionMap.getOrDefault(element, 0) + 1);
                }
            }
            Map<String, Integer> unionMap = new HashMap<>();
            unionMap.putAll(map1);
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                if (unionMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    unionMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (unionMap.isEmpty()) {
                return CONSTANT;
            }
            return CONSTANT
                    * intersectionMap.values().stream().reduce(0, (t, u) -> t + u)
                    / unionMap.values().stream().reduce(0, (t, u) -> t + u);
        }

    }

}
