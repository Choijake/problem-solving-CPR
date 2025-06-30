import java.util.*;

public class PG_20250610_의상 {

    class Solution {

        public int solution(String[][] clothes) {
            Map<String, Set<String>> categoryClothes = new HashMap<>();
            for (String[] clothesPair : clothes) {
                String category = clothesPair[1];
                String clothesName = clothesPair[0];
                if (categoryClothes.get(category) == null) {
                    categoryClothes.put(category, new HashSet<>());
                }
                categoryClothes.get(category).add(clothesName);
            }
            int result = 1;
            for (Map.Entry<String, Set<String>> entry : categoryClothes.entrySet()) {
                result *= (entry.getValue().size() + 1);
            }
            return result - 1;
        }

    }

}
