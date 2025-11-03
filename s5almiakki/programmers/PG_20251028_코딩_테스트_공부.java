import java.util.*;

public class PG_20251028_코딩_테스트_공부 {

    class Solution {

        private int targetAlgoPower = 0;
        private int targetCodingPower = 0;
        private Set<List<Integer>> visited = new HashSet<>();
        private List<Problem> problemsSortedByRewardAlgoPowerDesc = new ArrayList<>();
        private List<Problem> problemsSortedByRewardCodingPowerDesc = new ArrayList<>();

        // 제일 효율이 낮은 공부로도 300 시간만 있으면 최대 요구 알고력, 코딩력 충족 가능
        private int answer = 300;

        public int solution(int alp, int cop, int[][] problems) {
            // just studying
            problemsSortedByRewardAlgoPowerDesc.add(new Problem(0, 0, 1, 0, 1));
            problemsSortedByRewardAlgoPowerDesc.add(new Problem(0, 0, 0, 1, 1));
            problemsSortedByRewardCodingPowerDesc.add(new Problem(0, 0, 1, 0, 1));
            problemsSortedByRewardCodingPowerDesc.add(new Problem(0, 0, 0, 1, 1));
            for (int[] p : problems) {
                targetAlgoPower = Math.max(targetAlgoPower, p[0]);
                targetCodingPower = Math.max(targetCodingPower, p[1]);
                if (p[2] + p[3] <= p[4]) {
                    continue;
                }
                Problem problem = new Problem(p);
                problemsSortedByRewardAlgoPowerDesc.add(problem);
                problemsSortedByRewardCodingPowerDesc.add(problem);
            }
            problemsSortedByRewardAlgoPowerDesc.sort((o1, o2) -> Float.compare(o2.rewardAlgoPowerRatio, o1.rewardAlgoPowerRatio));
            problemsSortedByRewardCodingPowerDesc.sort((o1, o2) -> Float.compare(o2.rewardCodingPowerRatio, o1.rewardCodingPowerRatio));
            dfs(alp, cop, 0);
            return answer;
        }

        private void dfs(int currentAlgoPower, int currentCodingPower, int spentTime) {
            if (spentTime >= answer) {
                return;
            }
            if (currentAlgoPower >= targetAlgoPower && currentCodingPower >= targetCodingPower) {
                answer = spentTime;
                return;
            }
            List<Integer> args = List.of(currentAlgoPower, currentCodingPower, spentTime);
            if (visited.contains(args)) {
                return;
            }
            visited.add(args);
            int lackingAlgoPower = targetAlgoPower - currentAlgoPower;
            int lackingCodingPower = targetCodingPower - currentCodingPower;
            if (lackingAlgoPower > lackingCodingPower) {
                for (int i = 0; i < problemsSortedByRewardAlgoPowerDesc.size(); i++) {
                    Problem p = problemsSortedByRewardAlgoPowerDesc.get(i);
                    if (currentAlgoPower >= targetAlgoPower && p.rewardCodingPower == 0) {
                        continue;
                    }
                    if (currentCodingPower >= targetCodingPower && p.rewardAlgoPower == 0) {
                        continue;
                    }
                    if (p.isSolvable(currentAlgoPower, currentCodingPower)) {
                        dfs(currentAlgoPower + p.rewardAlgoPower, currentCodingPower + p.rewardCodingPower, spentTime + p.cost);
                    }
                }
            } else {
                for (int i = 0; i < problemsSortedByRewardCodingPowerDesc.size(); i++) {
                    Problem p = problemsSortedByRewardCodingPowerDesc.get(i);
                    if (currentAlgoPower >= targetAlgoPower && p.rewardCodingPower == 0) {
                        continue;
                    }
                    if (currentCodingPower >= targetCodingPower && p.rewardAlgoPower == 0) {
                        continue;
                    }
                    if (p.isSolvable(currentAlgoPower, currentCodingPower)) {
                        dfs(currentAlgoPower + p.rewardAlgoPower, currentCodingPower + p.rewardCodingPower, spentTime + p.cost);
                    }
                }
            }
        }

        private static class Problem {

            final int requiredAlgoPower;
            final int requiredCodingPower;
            final int rewardAlgoPower;
            final int rewardCodingPower;
            final float rewardAlgoPowerRatio;
            final float rewardCodingPowerRatio;
            final int cost;

            public Problem(int[] problem) {
                this(problem[0], problem[1], problem[2], problem[3], problem[4]);
            }

            public Problem(int requiredAlgoPower, int requiredCodingPower, int rewardAlgoPower, int rewardCodingPower, int cost) {
                this.requiredAlgoPower = requiredAlgoPower;
                this.requiredCodingPower = requiredCodingPower;
                this.rewardAlgoPower = rewardAlgoPower;
                this.rewardCodingPower = rewardCodingPower;
                rewardAlgoPowerRatio = (float) rewardAlgoPower / (float) cost;
                rewardCodingPowerRatio = (float) rewardCodingPower / (float) cost;
                this.cost = cost;
            }

            public boolean isSolvable(int currentAlgoPower, int currentCodingPower) {
                return currentAlgoPower >= requiredAlgoPower && currentCodingPower >= requiredCodingPower;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Problem)) {
                    return false;
                }
                if (this == o) {
                    return true;
                }
                Problem other = (Problem) o;
                return this.requiredAlgoPower == other.requiredAlgoPower && this.requiredCodingPower == other.requiredCodingPower
                        && this.rewardAlgoPower == other.rewardAlgoPower && this.rewardCodingPower == other.rewardCodingPower
                        && this.cost == other.cost;
            }

            @Override
            public int hashCode() {
                return Objects.hash(requiredAlgoPower, requiredCodingPower, rewardAlgoPower, rewardCodingPower, cost);
            }

        }

    }

}
