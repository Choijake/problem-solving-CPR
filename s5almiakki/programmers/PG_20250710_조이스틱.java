
public class PG_20250710_조이스틱 {

    class Solution {

        private int nameLength;

        public int solution(String name) {
            nameLength = name.length();
            int initialMask = 0;
            int letterChangeCnt = 0;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                letterChangeCnt += Math.min(c - 'A', 'Z' - c + 1);
                if (c != 'A') {
                    initialMask |= 1 << i;
                }
            }
            int minMovementCnt = Integer.MAX_VALUE;
            for (int turningPoint = 0; turningPoint < name.length(); turningPoint++) {
                minMovementCnt = Math.min(
                        minMovementCnt,
                        Math.min(
                                computeMovementCnt(turningPoint, 1, initialMask),
                                computeMovementCnt(turningPoint, -1, initialMask)));
            }
            return letterChangeCnt + minMovementCnt;
        }

        private int computeMovementCnt(int turningPoint, int direction, int nonAPositionMask) {
            int cursorPosition = 0;
            nonAPositionMask &= ~(1 << cursorPosition);
            int movementCnt = 0;
            while (nonAPositionMask != 0) {
                cursorPosition = mod(cursorPosition + direction, nameLength);
                nonAPositionMask &= ~(1 << cursorPosition);
                if (cursorPosition == turningPoint) {
                    direction = -direction;
                }
                movementCnt++;
            }
            return movementCnt;
        }

        private int mod(int a, int b) {
            return ((a % b) + b) % b;
        }

    }

}
