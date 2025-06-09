import java.util.*;

public class PG_20250530_전화번호_목록 {

    class Solution1 {

        public boolean solution(String[] phoneBook) {
            Arrays.sort(phoneBook);
            for (int i = 0; i < phoneBook.length - 1; i++) {
                if (phoneBook[i + 1].startsWith(phoneBook[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {

        public boolean solution(String[] phoneBook) {
            Set<String> phoneNums = new HashSet<>();
            for (String phoneNum : phoneBook) {
                phoneNums.add(phoneNum);
            }
            for (String phoneNum : phoneNums) {
                for (int i = 1; i < phoneNum.length(); i++) {
                    if (phoneNums.contains(phoneNum.substring(0, i))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
