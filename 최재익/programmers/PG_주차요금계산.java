import java.util.*;

class PG_주차요금계산 {
    static Map<Integer, Integer> time;
    static Map<Integer, Integer> log;
    static int basicTime;
    static int basicCharge;
    static int unitTime;
    static int unitCharge;
    public List<Integer> solution(int[] fees, String[] records) {
        time = new TreeMap<>();
        log = new HashMap<>();
        this.basicTime = fees[0];
        this.basicCharge = fees[1];
        this.unitTime = fees[2];
        this.unitCharge = fees[3];

        for(String r : records){
            String[] record = r.split(" ");
            int carNumber = Integer.parseInt(record[1]);

            if(record[2].equals("IN")){
                log.put(carNumber, toMinute(record[0]));
            }
            else if(record[2].equals("OUT")){
                int gapTime = toMinute(record[0]) - log.get(carNumber);

                if(time.containsKey(carNumber)){
                    time.put(carNumber, time.get(carNumber)+gapTime);
                }else time.put(carNumber, gapTime);

                log.remove(carNumber);
            }
        }

        if(log.size()>0){
            for(Map.Entry<Integer, Integer> entry : log.entrySet()){
                int carNumber = entry.getKey();
                int gapTime = toMinute("23:59") - entry.getValue();

                if(time.containsKey(carNumber)){
                    time.put(carNumber, time.get(carNumber)+gapTime);
                }else time.put(carNumber, gapTime);
            }
        }

        for(Map.Entry<Integer, Integer> entry : time.entrySet()){
            System.out.println("차량 번호 : "+entry.getKey()+", 사용 시간 : "+entry.getValue());
        }

        List<Integer> answer = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : time.entrySet()){
            int minute = entry.getValue();
            int charge = getCharge(minute);

            answer.add(charge);
        }

        return answer;
    }

    public int getCharge(int minute){
        int charge = 0;

        if(minute<=basicTime){
            charge = basicCharge;
        }
        else {
            charge = basicCharge + (int)Math.ceil(((double)minute-basicTime)/unitTime) * unitCharge;
        }

        return charge;
    }

    public int toMinute(String time){
        String[] hm = time.split(":");
        String hour = hm[0];
        String min = hm[1];
        int minute = 0;

        minute += (Integer.parseInt(hour)*60 + Integer.parseInt(min));

        return minute;
    }
}

//Integer.parseInt() 메서드는 문자열을 숫자로 변환할 때, 숫자 앞에 오는 "0"을 무시하고 실제 숫자 값으로 변환합니다.

//for(Map.Entry<Integer, Integer> entry : time.entrySet()){}

//TreeMap 키를 기준으로 자동 오름차순 정렬