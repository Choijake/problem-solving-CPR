
public class PG_20250718_다음_큰_숫자 {

    class Solution {

        public int solution(int n) {
            int mask = 1;
            int oneCnt = 0;
            // 왼쪽 비트가 0인 1 비트 중 가장 작은 것 찾기
            do {
                // 현재 비트가 0이면 건너뜀
                if ((n & mask) == 0) {
                    mask <<= 1;
                    continue;
                }
                oneCnt++;
                // 왼쪽 비트가 1이면 건너뜀
                if ((n & (mask << 1)) != 0) {
                    mask <<= 1;
                    continue;
                }
                break;
            } while (true);
            // 왼쪽 비트를 1로 만들고 그 오른쪽은 전부 0으로 만듦
            mask <<= 1;
            n |= mask;
            mask = ~(mask - 1);
            n &= mask;
            // (지금까지의 1 비트 개수 - 1)만큼 맨 오른쪽에 1 추가
            mask = (1 << (oneCnt - 1)) - 1;
            n |= mask;
            return n;
        }

    }

}
