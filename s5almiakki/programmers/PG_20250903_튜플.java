import java.util.*;

public class PG_20250903_튜플 {

    class Solution {

        public int[] solution(String s) {
            s = s.replace(" ", "").substring(2, s.length() - 2);
            String[] sets = s.split("\\}\\,\\{");
            Arrays.sort(sets, (o1, o2) -> o1.length() - o2.length());
            List<Integer> result = new ArrayList<>();
            for (String set : sets) {
                int[] elements = Arrays.stream(set.split("\\,"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int element : elements) {
                    if (!result.contains(element)) {
                        result.add(element);
                    }
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }

    }

}
