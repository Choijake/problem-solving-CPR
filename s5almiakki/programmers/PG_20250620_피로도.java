
public class PG_20250620_피로도 {
    
    class Solution {
        
        private int energy;
        private int[][] dungeons;
        private int visitedBitMask = 0;
        private int answer = 0;
        
        public int solution(int k, int[][] dungeons) {
            this.energy = k;
            this.dungeons = dungeons;
            for (int i = 0; i < dungeons.length; i++) {
                this.dfs(i);
            }
            return answer;
        }
        
        private void dfs(int idx) {
            enter(idx);
            int visitedCnt = Integer.bitCount(visitedBitMask);
            if (this.answer < visitedCnt) {
                this.answer = visitedCnt;
            }
            for (int i = 0; i < dungeons.length; i++) {
                if (isVisited(i)) {
                    continue;
                }
                if (!hasEnoughEnergy(i)) {
                    continue;
                }
                dfs(i);
            }
            exit(idx);
        }
        
        private boolean isVisited(int idx) {
            return (visitedBitMask & (1 << idx)) != 0;
        }
        
        private boolean hasEnoughEnergy(int idx) {
            return this.energy >= dungeons[idx][0];
        }
        
        private void enter(int idx) {
            this.energy -= dungeons[idx][1];
            visitedBitMask |= (1 << idx);
        }
        
        private void exit(int idx) {
            this.energy += dungeons[idx][1];
            visitedBitMask &= ~(1 << idx);
        }
        
    }

}
