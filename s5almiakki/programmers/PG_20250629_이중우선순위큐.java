import java.util.*;

public class PG_20250629_이중우선순위큐 {
    
    class Solution {
        
        public int[] solution(String[] operations) {
            PriorityDeque pd = new PriorityDeque();
            for (String operation : operations) {
                switch (operation) {
                    case "D 1":
                        pd.deleteMaxValue();
                        break;
                    case "D -1":
                        pd.deleteMinValue();
                        break;
                    default:
                        pd.insert(Integer.parseInt(operation.split(" ")[1]));
                        break;
                }
            }
            return new int[] { pd.getMaxValue(), pd.getMinValue() };
        }
        
        static class PriorityDeque {
            
            private SortedMap<Integer, Integer> sm = new TreeMap<>();
            
            public void insert(Integer value) {
                this.sm.put(value, this.sm.getOrDefault(value, 0) + 1);
            }
            
            public void deleteMaxValue() {
                if (this.sm.isEmpty()) {
                    return;
                }
                Integer maxValue = this.sm.lastKey();
                if (this.sm.get(maxValue) == null) {
                    return;
                }
                this.sm.put(maxValue, this.sm.get(maxValue) - 1);
                if (this.sm.get(maxValue).compareTo(0) <= 0) {
                    this.sm.remove(maxValue);
                }
            }
            
            public void deleteMinValue() {
                if (this.sm.isEmpty()) {
                    return;
                }
                Integer minValue = this.sm.firstKey();
                if (this.sm.get(minValue) == null) {
                    return;
                }
                this.sm.put(minValue, this.sm.get(minValue) - 1);
                if (this.sm.get(minValue).compareTo(0) <= 0) {
                    this.sm.remove(minValue);
                }
            }
            
            public Integer getMaxValue() {
                if (this.sm.isEmpty()) {
                    return 0;
                }
                return this.sm.lastKey();
            }
            
            public Integer getMinValue() {
                if (this.sm.isEmpty()) {
                    return 0;
                }
                return this.sm.firstKey();
            }
            
        }
        
    }

}
