import java.util.*;

public class PG_20250919_주차_요금_계산 {

    class Solution {

        public int[] solution(int[] fees, String[] records) {
            SortedMap<Integer, ParkingHistory> parkingHistories = new TreeMap<>();
            for (String record : records) {
                String[] info = record.split(" ");
                int time = toIntTime(info[0]);
                int car = Integer.parseInt(info[1]);
                switch (info[2]) {
                    case "IN":
                        if (parkingHistories.get(car) == null) {
                            parkingHistories.put(car, new ParkingHistory());
                        }
                        parkingHistories.get(car).goIn(time);
                        break;
                    case "OUT":
                        parkingHistories.get(car).goOut(time);
                        break;
                }
            }
            int lastOutTime = toIntTime("23:59");
            for (ParkingHistory history : parkingHistories.values()) {
                if (history.inTime != -1) {
                    history.goOut(lastOutTime);
                }
            }
            return parkingHistories.values().stream()
                    .mapToInt(history -> {
                        if (history.duration <= fees[0]) {
                            return fees[1];
                        }
                        int additionalTime = history.duration - fees[0];
                        return fees[1] + (additionalTime + fees[2] - 1) / fees[2] * fees[3];
                    })
                    .toArray();
        }

        private int toIntTime(String time) {
            String[] hm = time.split(":");
            return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
        }

        private static class ParkingHistory {

            int inTime = -1;
            int duration = 0;

            public void goIn(int time) {
                inTime = time;
            }

            public void goOut(int time) {
                duration += time - inTime;
                inTime = -1;
            }

        }

    }

}
