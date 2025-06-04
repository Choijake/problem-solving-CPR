import java.util.*;
import java.util.stream.*;

public class PG_20250604_가장_큰_수 {

    class Solution {

        public String solution(int[] numbers) {
            String result = Arrays.stream(numbers)
                    .mapToObj(String::valueOf)
                    .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                    .collect(Collectors.joining());
            return result.chars().allMatch(c -> c == '0')
                    ? "0"
                    : result;
        }

    }

}
