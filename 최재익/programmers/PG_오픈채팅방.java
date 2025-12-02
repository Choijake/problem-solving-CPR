import java.util.*;

class PG_오픈채팅방 {
    static HashMap<String, String> map;
    static List<String[]> logs;
    public List<String> solution(String[] record) {
        logs = new ArrayList<>();
        map = new HashMap<>();

        for(String r : record){
            String[] log = r.split(" ");
            logs.add(log);

            if(!log[0].equals("Leave")){
                map.put(log[1], log[2]);
            }
        }

        List<String> answer = new ArrayList<>();
        for(String[] l : logs){
            String name = map.get(l[1]);
            if(l[0].equals("Enter")){
                answer.add(name+"님이 들어왔습니다.");
            }
            else if(l[0].equals("Leave")){
                answer.add(name+"님이 나갔습니다.");
            }
        }

        return answer;
    }
}