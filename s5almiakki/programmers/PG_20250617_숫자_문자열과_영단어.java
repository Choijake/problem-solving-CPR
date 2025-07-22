
public class PG_20250617_숫자_문자열과_영단어 {

    class Solution1 {

        public int solution(String s) {
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            int head = 0;
            while (head < arr.length) {
                if ('0' <= arr[head] && arr[head] <= '9') {
                    sb.append(arr[head]);
                    head++;
                    continue;
                }
                switch (arr[head]) {
                    case 'z':
                        sb.append(0);
                        head += 4;
                        break;
                    case 'o':
                        sb.append(1);
                        head += 3;
                        break;
                    case 't':
                        switch (arr[head + 1]) {
                            case 'w':
                                sb.append(2);
                                head += 3;
                                break;
                            case 'h':
                                sb.append(3);
                                head += 5;
                                break;
                        }
                        break;
                    case 'f':
                        switch (arr[head + 1]) {
                            case 'o':
                                sb.append(4);
                                head += 4;
                                break;
                            case 'i':
                                sb.append(5);
                                head += 4;
                                break;
                        }
                        break;
                    case 's':
                        switch (arr[head + 1]) {
                            case 'i':
                                sb.append(6);
                                head += 3;
                                break;
                            case 'e':
                                sb.append(7);
                                head += 5;
                                break;
                        }
                        break;
                    case 'e':
                        sb.append(8);
                        head += 5;
                        break;
                    case 'n':
                        sb.append(9);
                        head += 4;
                        break;
                }
            }
            return Integer.parseInt(sb.toString());
        }

    }
    
    class Solution2 {
        
        public int solution(String s) {
            String[] numWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
            };
            String result = s;
            for (int i = 0; i <= 9; i++) {
                result = result.replaceAll(numWords[i], String.valueOf(i));
            }
            return Integer.parseInt(result);
        }
        
    }

}
