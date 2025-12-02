import java.util.*;

class PG_붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] attack : attacks){
            int time = attack[0];
            int damage = attack[1];
            map.put(time, damage);
        }

        int MAX_HEALTH=health;
        int time=0;
        int sequence=0;
        while(true){
            if(map.isEmpty())break;

            time++;

            if(map.containsKey(time)){
                int damage = map.get(time);
                map.remove(time);
                health -= damage;
                if(health<=0)return -1;
                sequence = 0;
            }else{
                sequence++;

                if(health<MAX_HEALTH){
                    health = Math.min((health+bandage[1]), MAX_HEALTH);
                }
                if(sequence==bandage[0]){
                    health = Math.min((health+bandage[2]), MAX_HEALTH);
                    sequence = 0;
                }
            }
        }

        return health;
    }
}