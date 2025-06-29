import java.util.*;

public class PG_20250629_디스크_컨트롤러 {

    class Solution {

        private Deque<Job> unrequestedJobs = new ArrayDeque<>();
        private PriorityQueue<Job> requestedJobs = new PriorityQueue<>();
        private Job runningJob = null;
        private int currentTime = -1;
        private int turnaroundTimeSum = 0;

        public int solution(int[][] jobs) {
            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
            for (int i = 0; i < jobs.length; i++) {
                unrequestedJobs.add(new Job(jobs[i][1], jobs[i][0], i));
            }
            do {
                currentTime++;
                finishJob();
                requestJob();
                runJob();
            } while (isJobRemaining());
            return turnaroundTimeSum / jobs.length;
        }

        private void finishJob() {
            if (runningJob == null) {
                return;
            }
            if (!runningJob.isFinishable(currentTime)) {
                return;
            }
            turnaroundTimeSum += currentTime - runningJob.getRequestTime();
            runningJob = null;
        }

        private void requestJob() {
            while (true) {
                if (unrequestedJobs.isEmpty()) {
                    break;
                }
                if (currentTime < unrequestedJobs.peek().getRequestTime()) {
                    break;
                }
                requestedJobs.add(unrequestedJobs.remove());
            }
        }

        private void runJob() {
            if (runningJob != null) {
                return;
            }
            if (requestedJobs.isEmpty()) {
                return;
            }
            runningJob = requestedJobs.remove();
            runningJob.start(currentTime);
        }

        private boolean isJobRemaining() {
            return runningJob != null || !requestedJobs.isEmpty() || !unrequestedJobs.isEmpty();
        }

        static class Job implements Comparable<Job> {

            private int requiredDuration;
            private int requestTime;
            private int startTime;
            private int idx;

            public Job(int requiredDuration, int requestTime, int idx) {
                this.requiredDuration = requiredDuration;
                this.requestTime = requestTime;
                this.idx = idx;
            }

            public void start(int currentTime) {
                this.startTime = currentTime;
            }

            public boolean isFinishable(int currentTime) {
                return currentTime - startTime >= requiredDuration;
            }

            @Override
            public int compareTo(Job other) {
                if (this.requiredDuration != other.requiredDuration) {
                    return this.requiredDuration - other.requiredDuration;
                }
                if (this.requestTime != other.requestTime) {
                    return this.requestTime - other.requestTime;
                }
                return this.idx - other.idx;
            }

            public int getRequiredDuration() {
                return this.requiredDuration;
            }

            public int getRequestTime() {
                return this.requestTime;
            }

            public int getIdx() {
                return this.idx;
            }

        }

    }

}
