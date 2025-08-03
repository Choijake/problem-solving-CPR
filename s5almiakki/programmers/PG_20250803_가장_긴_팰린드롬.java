
public class PG_20250803_가장_긴_팰린드롬 {

    class Solution {

        public int solution(String s) {
            for (int length = s.length(); length >= 2; length--) {
                for (int startIdx = 0; startIdx <= s.length() - length; startIdx++) {
                    if (isPalindrome(s, startIdx, startIdx + length - 1)) {
                        return length;
                    }
                }
            }
            return 1;
        }

        private boolean isPalindrome(String s, int startIdx, int endIdx) {
            do {
                if (s.charAt(startIdx) != s.charAt(endIdx)) {
                    return false;
                }
                startIdx++;
                endIdx--;
            } while (startIdx < endIdx);
            return true;
        }

    }

}
