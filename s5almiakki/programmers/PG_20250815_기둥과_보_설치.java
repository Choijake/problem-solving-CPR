import java.util.*;

public class PG_20250815_기둥과_보_설치 {

    class Solution {

        private int wallSize;
        private boolean[][] pillars;
        private boolean[][] beams;

        private void init(int n) {
            wallSize = n + 1;
            pillars = new boolean[n + 1][n + 1];
            beams = new boolean[n + 1][n + 1];
        }

        public int[][] solution(int n, int[][] build_frame) {
            init(n);
            for (int[] command : build_frame) {
                if (command[3] == 0) {
                    if (command[2] == 0) { // remove pillar
                        pillars[command[0]][command[1]] = false;
                        if (!isValidAroundPillar(command[0], command[1])) {
                            pillars[command[0]][command[1]] = true;
                        }
                    } else { // remove beam
                        beams[command[0]][command[1]] = false;
                        if (!isValidAroundBeam(command[0], command[1])) {
                            beams[command[0]][command[1]] = true;
                        }
                    }
                } else {
                    if (command[2] == 0) { // add pillar
                        if (isPillarValid(command[0], command[1])) {
                            pillars[command[0]][command[1]] = true;
                        }
                    } else { // add beam
                        if (isBeamValid(command[0], command[1])) {
                            beams[command[0]][command[1]] = true;
                        }
                    }
                }
            }
            List<int[]> result = new ArrayList<>();
            for (int x = 0; x < wallSize; x++) {
                for (int y = 0; y < wallSize; y++) {
                    if (pillars[x][y]) {
                        result.add(new int[] { x, y, 0 });
                    }
                    if (beams[x][y]) {
                        result.add(new int[] { x, y, 1 });
                    }
                }
            }
            return result.stream().toArray(size -> new int[size][]);
        }

        private boolean isValidAroundPillar(int x, int y) {
            if (y + 1 < wallSize) {
                // 상단 기둥
                if (pillars[x][y + 1] && !isPillarValid(x, y + 1)) {
                    return false;
                }
                // 좌상단 보
                if (x - 1 >= 0 && beams[x - 1][y + 1] && !isBeamValid(x - 1, y + 1)) {
                    return false;
                }
                // 우상단 보
                if (beams[x][y + 1] && !isBeamValid(x, y + 1)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidAroundBeam(int x, int y) {
            // 좌측 기둥
            if (pillars[x][y] && !isPillarValid(x, y)) {
                return false;
            }
            if (x + 1 < wallSize) {
                // 우측 기둥
                if (pillars[x + 1][y] && !isPillarValid(x + 1, y)) {
                    return false;
                }
                // 우측 보
                if (beams[x + 1][y] && !isBeamValid(x + 1, y)) {
                    return false;
                }
            }
            // 좌측 보
            if (x - 1 >= 0 && beams[x - 1][y] && !isBeamValid(x - 1, y)) {
                return false;
            }
            return true;
        }

        private boolean isPillarValid(int x, int y) {
            if (y == 0) {
                return true;
            }
            if (y - 1 >= 0 && pillars[x][y - 1]) {
                return true;
            }
            if (x - 1 >= 0 && beams[x - 1][y]) {
                return true;
            }
            if (beams[x][y]) {
                return true;
            }
            return false;
        }

        private boolean isBeamValid(int x, int y) {
            if (y - 1 >= 0 && pillars[x][y - 1]) {
                return true;
            }
            if (x + 1 < wallSize) {
                if (y - 1 >= 0 && pillars[x + 1][y - 1]) {
                    return true;
                }
                if (x - 1 >= 0 && beams[x - 1][y] && beams[x + 1][y]) {
                    return true;
                }
            }
            return false;
        }

    }

}
