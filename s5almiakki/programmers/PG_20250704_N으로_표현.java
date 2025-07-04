import java.util.*;

public class PG_20250704_N으로_표현 {

    class Solution {

        private List<Operation> operands = new ArrayList<>();
        private Map<Integer, Integer> usageCnts = new HashMap<>();
        private int minNumber;
        private int maxNumber;

        public int solution(int N, int number) {
            minNumber = -number;
            maxNumber = number * 10;
            for (int i = minNumber; i <= maxNumber; i++) {
                usageCnts.put(i, Integer.MAX_VALUE);
            }
            PriorityQueue<Operation> operations = new PriorityQueue<>();
            for (int usageCnt = 1; ; usageCnt++) {
                int startNumber = N;
                for (int i = 1; i < usageCnt; i++) {
                    startNumber *= 10;
                    startNumber += N;
                }
                if (usageCnts.size() < startNumber) {
                    break;
                }
                Operation operation = new Operation(startNumber, usageCnt);
                operations.add(operation);
                operations.add(new Operation(-startNumber, usageCnt));
                operands.add(operation);
                usageCnts.put(startNumber, usageCnt);
                usageCnts.put(-startNumber, usageCnt);
            }
            do {
                Operation currentOperation = operations.remove();
                for (Operation operand : operands) {
                    int newUsageCnt = currentOperation.getUsageCnt() + operand.getUsageCnt();
                    int newNumber = currentOperation.getNumber() + operand.getNumber();
                    updateUsageCnt(usageCnts, operations, newNumber, newUsageCnt);
                    newNumber = currentOperation.getNumber() - operand.getNumber();
                    updateUsageCnt(usageCnts, operations, newNumber, newUsageCnt);
                    newNumber = currentOperation.getNumber() * operand.getNumber();
                    updateUsageCnt(usageCnts, operations, newNumber, newUsageCnt);
                    newNumber = currentOperation.getNumber() / operand.getNumber();
                    updateUsageCnt(usageCnts, operations, newNumber, newUsageCnt);
                }
            } while (!operations.isEmpty());
            return usageCnts.get(number) <= 8 ? usageCnts.get(number) : -1;
        }

        private void updateUsageCnt(
                Map<Integer, Integer> usageCnts, PriorityQueue<Operation> operations, int number, int usageCnt
        ) {
            if (number < minNumber || maxNumber < number) {
                return;
            }
            if (usageCnt >= usageCnts.get(number)) {
                return;
            }
            if (usageCnt > 8) {
                return;
            }
            usageCnts.put(number, usageCnt);
            operations.add(new Operation(number, usageCnt));
        }

        static class Operation implements Comparable<Operation> {

            private int number;
            private int usageCnt;

            public Operation(int number, int usageCnt) {
                this.number = number;
                this.usageCnt = usageCnt;
            }

            public int getNumber() {
                return this.number;
            }

            public int getUsageCnt() {
                return this.usageCnt;
            }

            @Override
            public int compareTo(Operation o) {
                return this.usageCnt - o.usageCnt;
            }

            @Override
            public String toString() {
                return "[number=" + this.number + ", usageCnt=" + usageCnt + "]";
            }

        }

    }

}
