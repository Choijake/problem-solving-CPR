import java.util.*;

class PG_K진수에서소수개수구하기 {
    static int n;
    static int k;
    public int solution(int n, int k) {
        this.n = n;
        this.k = k;

        String convert = Integer.toString(n, k);
        String[] arr = convert.split("0");

        int answer = 0;
        for(String s : arr){
            if(s.equals(""))continue;
            if(isPrimeNumber(Long.parseLong(s)))answer++;
        }

        return answer;
    }

    public boolean isPrimeNumber(long number){
        if(number<=1)return false;

        for(long i=2; i<=Math.sqrt(number); i++){
            if(number%i==0)return false;
        }

        return true;
    }
}

//line 25 : Math.sqrt()는 입출력 타입이 전부 double, 하지만 자바 컴파일러는 작은 데이터 타입이 큰 데이터 타입에 할당될 때 자동으로 형변환을 해준다.