import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ_1283 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Character> set = new HashSet<>();
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<N; i++){
            boolean flag = false;
            String[] words = br.readLine().split(" ");
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            String modified = "";

            for(int w=0; w<words.length; w++){
                String word = words[w];

                if(set.contains(Character.toUpperCase(word.charAt(0)))
                        || set.contains(Character.toLowerCase(word.charAt(0)))){
                    continue;
                }
                else{
                    idx = w;
                    modified = "["+word.charAt(0)+"]"+word.substring(1);
                    set.add(word.charAt(0));
                    flag = true;
                    break;
                }
            }

            if(!flag){
                p:
                for(int w=0; w<words.length; w++){
                    String word = words[w];

                    for(int j=0; j<word.length(); j++){
                        char a = word.charAt(j);

                        if(set.contains(Character.toUpperCase(a))
                                || set.contains(Character.toLowerCase(a))){
                            continue;
                        }
                        else{
                            modified = word.substring(0, j)+"["+a+"]"+word.substring(j+1);
                            set.add(a);
                            idx = w;
                            break p;
                        }
                    }
                }
            }

            for(int j=0; j<words.length; j++){
                if(j==idx && !modified.equals(""))sb.append(modified).append(" ");
                else sb.append(words[j]).append(" ");
            }

            answer.append(sb).append("\n");
        }

        System.out.print(answer.toString());
    }
}