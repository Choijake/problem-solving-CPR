import java.util.*;

class PG_수식최대화 {
    static List<String> list;
    static Set<String> ops;
    static List<String> opsList;
    static boolean[] visited;
    static Long answer;
    public long solution(String expression) {
        list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        ops = new HashSet<>();

        for(char ch : expression.toCharArray()){
            if(Character.isDigit(ch)){
                sb.append(ch);
            }
            else{
                list.add(sb.toString());
                list.add(String.valueOf(ch));
                ops.add(String.valueOf(ch));
                sb = new StringBuilder();
            }
        }
        list.add(sb.toString());

        visited = new boolean[ops.size()];
        opsList = new ArrayList<>(ops);
        answer = 0L;

        permutation(0, new String[ops.size()]);

        return answer;
    }

    public long getResult(String[] seq){
        List<String> newList = new ArrayList<>();
        for(String l : list){
            newList.add(l);
        }

        for(String op : seq){
            int i=0;
            while (i < newList.size()) {
                if(newList.get(i).equals(op)){
                    long fore = Long.parseLong(newList.get(i-1));
                    long rear = Long.parseLong(newList.get(i+1));

                    newList.set(i-1, String.valueOf(calc(fore, rear, op)));
                    newList.remove(i);
                    newList.remove(i);

                    i -= 1;
                }
                else {
                    i++;
                }
            }
        }

        return Long.parseLong(newList.get(0));
    }

    public long calc(long fore, long rear, String op){
        if(op.equals("*")){
            return fore*rear;
        }
        else if(op.equals("+")){
            return fore+rear;
        }
        else return fore-rear;
    }

    public void permutation(int depth, String[] seq){
        if(depth==ops.size()){
            Long result = getResult(seq);
            result = result<0?-1*result:result;
            answer = Math.max(answer, result);
        }

        for(int i=0; i<opsList.size(); i++){
            if(visited[i])continue;
            visited[i] = true;
            seq[depth] = opsList.get(i);
            permutation(depth+1, seq);
            visited[i] = false;
        }
    }
}