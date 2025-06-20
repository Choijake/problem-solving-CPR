public class PG_20250620_카펫 {
    
    class Solution {
        
        public int[] solution(int brown, int yellow) {
            int totalArea = brown + yellow;
            for (int width = 1; width <= totalArea; width++) {
                if (totalArea % width != 0) {
                    continue;
                }
                int height = totalArea / width;
                if (height + width - 2 == (brown >> 1)) {
                    return new int[] { height, width };
                }
            }
            return null;
        }
        
    }

}
