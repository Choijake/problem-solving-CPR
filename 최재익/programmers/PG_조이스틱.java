class PG_조이스틱 {
    public int solution(String name) {
        int answer = 0;

        for(int i=0; i<name.length(); i++){
            int updown = Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            answer += updown;
        }

        int move = Integer.MAX_VALUE;
        for(int i=0; i<name.length(); i++){
            int next = i+1;
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }

            int goAndTurn = i*2+name.length()-next;
            int turnAndGo = (name.length()-next)*2+i;

            move = Math.min(move, Math.min(goAndTurn, turnAndGo));
        }

        return answer+move;
    }
}