
public class PG_20250820_110_옮기기 {

    class Solution {

        public String[] solution(String[] s) {
            String[] results = new String[s.length];
            int resultIdx = 0;
            for (String target : s) {
                results[resultIdx] = process(target);
                resultIdx++;
            }
            return results;
        }

        private String process(String target) {
            StringBuilder result = new StringBuilder();
            int cntOf110 = 0;
            for (int i = 0; i < target.length(); i++) {
                result.append(target.charAt(i));
                int rl = result.length();
                if (rl < 3) {
                    continue;
                }
                if (result.charAt(rl - 3) == '1'
                        && result.charAt(rl - 2) == '1'
                        && result.charAt(rl - 1) == '0') {
                    result.delete(rl - 3, rl);
                    cntOf110++;
                }
            }
            for (int i = 0; i < cntOf110; i++) {
                result.insert(result.lastIndexOf("0") + 1, "110");
            }
            return result.toString();
        }

    }

}
