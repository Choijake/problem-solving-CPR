import java.util.*;

public class PG_20250616_프로세스 {

    class Solution {

        public int solution(int[] priorities, int location) {
            Queue<Process> queue = new ArrayDeque<>();
            for (int i = 0; i < priorities.length; i++) {
                queue.add(new Process(i, priorities[i]));
            }
            int order = 0;
            while (true) {
                Process currentProcess = queue.remove();
                if (!hasHighestPriority(queue, currentProcess)) {
                    queue.add(currentProcess);
                    continue;
                }
                order++;
                if (currentProcess.getId() == location) {
                    return order;
                }
            }
        }

        private boolean hasHighestPriority(Queue<Process> queue, Process targetProcess) {
            for (Process process : queue) {
                if (process.getPriority() > targetProcess.getPriority()) {
                    return false;
                }
            }
            return true;
        }

        static class Process {

            private int id;
            private int priority;

            public Process(int id, int priority) {
                this.id = id;
                this.priority = priority;
            }

            public int getId() {
                return this.id;
            }

            public int getPriority() {
                return this.priority;
            }

        }

    }

}
