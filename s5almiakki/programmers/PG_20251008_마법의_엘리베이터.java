import java.util.*;

public class PG_20251008_마법의_엘리베이터 {

    class Solution {

        public int solution(int storey) {
            Queue<Element> queue = new ArrayDeque<>();
            queue.add(new Element(storey));
            int answer = Integer.MAX_VALUE;
            do {
                Element currentElement = queue.remove();
                if (currentElement.number == 0) {
                    answer = Math.min(answer, currentElement.buttonCnt);
                    continue;
                }
                // least significant number
                int lsNum = currentElement.number % 10;
                if (lsNum < 5) {
                    queue.add(new Element(
                            currentElement.buttonCnt + lsNum,
                            currentElement.number / 10));
                } else if (lsNum > 5) {
                    queue.add(new Element(
                            currentElement.buttonCnt + 10 - lsNum,
                            currentElement.number / 10 + 1));
                } else {
                    queue.add(new Element(
                            currentElement.buttonCnt + lsNum,
                            currentElement.number / 10));
                    queue.add(new Element(
                            currentElement.buttonCnt + lsNum,
                            currentElement.number / 10 + 1));
                }
            } while (!queue.isEmpty());
            return answer;
        }

        private static class Element {

            int buttonCnt;
            int number;

            public Element(int number) {
                this(0, number);
            }

            public Element(int buttonCnt, int number) {
                this.buttonCnt = buttonCnt;
                this.number = number;
            }

        }

    }

}
