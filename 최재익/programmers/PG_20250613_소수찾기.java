import java.util.*;

class Solution {
    private String[] strArr;
    private boolean[] visited;
    private int answer;
    private HashSet<Integer> set;

    public int solution(String numbers) {
        this.strArr = numbers.split("");
        this.visited = new boolean[strArr.length];
        this.answer = 0;
        this.set = new HashSet<>();

        permutation(0, "");

        for(Integer num : set){
            if(checkPrimeNumber(num)){
                answer++;
            }
        }

        return answer;
    }

    public void permutation(int depth, String result){
        if(!result.isEmpty()){
            set.add(Integer.valueOf(result));
        }

        if(depth==strArr.length)return;

        for(int i=0; i<strArr.length; i++){
            if(visited[i])continue;

            visited[i] = true;
            permutation(depth+1, result+strArr[i]);
            visited[i] = false;
        }
    }

    public boolean checkPrimeNumber(int number){
        if(number<=1)return false;
        if(number<=3)return true;
        if(number%2==0 || number%3==0)return false;

        for(int i=5; i*i<=number; i=i+6){
            if(number%i==0 || number%(i+2)==0)return false;
        }

        return true;
    }
}