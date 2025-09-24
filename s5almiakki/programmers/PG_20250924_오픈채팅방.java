import java.util.*;

public class PG_20250924_오픈채팅방 {

    class Solution {

        public String[] solution(String[] record) {
            Map<String, String> idNicknames = new HashMap<>();
            for (String r : record) {
                String[] splitted = r.split(" ");
                if (splitted[0].equals("Leave")) {
                    continue;
                }
                idNicknames.put(splitted[1], splitted[2]);
            }
            List<String> answer = new ArrayList<>();
            for (int i = 0; i < record.length; i++) {
                String[] splitted = record[i].split(" ");
                switch (splitted[0]) {
                    case "Enter":
                        answer.add(idNicknames.get(splitted[1]) + "님이 들어왔습니다.");
                        break;
                    case "Leave":
                        answer.add(idNicknames.get(splitted[1]) + "님이 나갔습니다.");
                        break;
                }
            }
            return answer.toArray(new String[answer.size()]);
        }

    }

}
