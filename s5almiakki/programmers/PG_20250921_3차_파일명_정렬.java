import java.util.*;

public class PG_20250921_3차_파일명_정렬 {

    class Solution {

        public String[] solution(String[] files) {
            String[] result = Arrays.copyOf(files, files.length);
            Arrays.sort(result, Solution::compareFileNames);
            return result;
        }

        private static int compareFileNames(String fileName1, String fileName2) {
            int numberHeadIdx1 = 0;
            while (!Character.isDigit(fileName1.charAt(numberHeadIdx1))) {
                numberHeadIdx1++;
            }
            String head1 = fileName1.substring(0, numberHeadIdx1).toLowerCase();
            int numberHeadIdx2 = 0;
            while (!Character.isDigit(fileName2.charAt(numberHeadIdx2))) {
                numberHeadIdx2++;
            }
            String head2 = fileName2.substring(0, numberHeadIdx2).toLowerCase();
            if (!head1.equals(head2)) {
                return head1.compareTo(head2);
            }

            int tailHeadIdx1 = numberHeadIdx1;
            while (tailHeadIdx1 < fileName1.length() && Character.isDigit(fileName1.charAt(tailHeadIdx1))) {
                tailHeadIdx1++;
            }
            String number1 = fileName1.substring(numberHeadIdx1, tailHeadIdx1);
            int tailHeadIdx2 = numberHeadIdx2;
            while (tailHeadIdx2 < fileName2.length() && Character.isDigit(fileName2.charAt(tailHeadIdx2))) {
                tailHeadIdx2++;
            }
            String number2 = fileName2.substring(numberHeadIdx2, tailHeadIdx2);
            return Integer.parseInt(number1) - Integer.parseInt(number2);
        }

    }

}
