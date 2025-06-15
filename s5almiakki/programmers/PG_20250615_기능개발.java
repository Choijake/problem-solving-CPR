import java.util.*;

public class PG_20250615_기능개발 {

    class Solution {

        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Task> queue = new ArrayDeque<>();
            for (int i = 0; i < progresses.length; i++) {
                queue.add(new Task(progresses[i], speeds[i]));
            }
            List<Integer> taskCnts = new ArrayList<>();
            while (!queue.isEmpty()) {
                for (Task task : queue) {
                    task.execute();
                }
                int taskCnt = 0;
                while (queue.peek().isDone()) {
                    queue.remove();
                    taskCnt++;
                    if (queue.isEmpty()) {
                        break;
                    }
                }
                if (taskCnt != 0) {
                    taskCnts.add(taskCnt);
                }
            }
            return taskCnts.stream().mapToInt(i -> i).toArray();
        }

        static class Task {

            private int progress;
            private int speed;

            public Task(int progress, int speed) {
                this.progress = progress;
                this.speed = speed;
            }

            public void execute() {
                this.progress += this.speed;
            }

            public boolean isDone() {
                return this.progress >= 100;
            }

            public int getProgress() {
                return this.progress;
            }

            public int getSpeed() {
                return this.speed;
            }

        }

    }

}
