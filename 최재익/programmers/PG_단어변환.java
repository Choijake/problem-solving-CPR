import java.util.*;
class PG_단어변환 {
    static int answer;
    static String target;
    static String[] words;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        answer = Integer.MAX_VALUE;

        visited = new boolean[words.length];
        dfs(begin, 0);

        return answer==Integer.MAX_VALUE?0:answer;
    }

    public void dfs(String word, int count){
        if(word.equals(target)){
            answer = Math.min(answer, count);
        }

        if(count==words.length)return;

        for(int i=0; i<words.length; i++){
            if(visited[i])continue;
            if(check(word, words[i])){
                visited[i] = true;
                dfs(words[i], count+1);
            }
            visited[i] = false;
        }
    }

    public boolean check(String from, String to){
        int count = 0;
        for(int i=0; i<from.length(); i++){
            if(from.charAt(i)==to.charAt(i))count++;
        }
        return from.length()==count+1;
    }
}