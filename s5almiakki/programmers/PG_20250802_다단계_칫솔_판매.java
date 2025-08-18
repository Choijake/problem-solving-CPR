import java.util.*;

public class PG_20250802_다단계_칫솔_판매 {

    class Solution {

        private Map<String, Integer> enrollmentIndices = new HashMap<>();
        private int[] referralIndices;
        private int[] sellerIndices;

        private void init(String[] enroll, String[] referral, String[] seller) {
            for (int i = 0; i < enroll.length; i++) {
                enrollmentIndices.put(enroll[i], i);
            }
            referralIndices = new int[referral.length];
            for (int i = 0; i < referral.length; i++) {
                if (referral[i].equals("-")) {
                    referralIndices[i] = -1;
                } else {
                    referralIndices[i] = enrollmentIndices.get(referral[i]);
                }
            }
            sellerIndices = new int[seller.length];
            for (int i = 0; i < seller.length; i++) {
                sellerIndices[i] = enrollmentIndices.get(seller[i]);
            }
        }

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            init(enroll, referral, seller);
            int[] result = new int[enroll.length];
            for (int i = 0; i < sellerIndices.length; i++) {
                transmitIncome(result, sellerIndices[i], amount[i] * 100);
            }
            return result;
        }

        private void transmitIncome(int[] result, int sellerIdx, int amount) {
            int transmittedIncome = amount / 10;
            result[sellerIdx] += amount - transmittedIncome;
            int referralIdx = referralIndices[sellerIdx];
            if (referralIdx == -1) {
                return;
            }
            transmitIncome(result, referralIdx, transmittedIncome);
        }

    }

}
