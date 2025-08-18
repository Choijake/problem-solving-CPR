import java.util.*;

public class PG_20250804_1차_셔틀버스 {

    class Solution {

        public String solution(int n, int t, int m, String[] timetable) {
            List<Integer> crewArrivalTimes = new ArrayList<>();
            for (int i = 0; i < timetable.length; i++) {
                crewArrivalTimes.add(toMinutes(timetable[i]));
            }
            crewArrivalTimes.sort(Comparator.reverseOrder());
            List<Shuttle> shuttles = new ArrayList<>();
            int arrivalTime = toMinutes("09:00");
            for (int i = 0; i < n; i++) {
                shuttles.add(new Shuttle(arrivalTime));
                arrivalTime += t;
            }
            for (Shuttle shuttle : shuttles) {
                do {
                    if (crewArrivalTimes.size() == 0) {
                        break;
                    }
                    if (shuttle.passengerCnt == m) {
                        break;
                    }
                    int crewArrivalTime = crewArrivalTimes.get(crewArrivalTimes.size() - 1);
                    if (shuttle.arrivalTime < crewArrivalTime) {
                        break;
                    }
                    crewArrivalTimes.remove(crewArrivalTimes.size() - 1);
                    shuttle.passengerArrivalTimes.add(crewArrivalTime);
                    shuttle.passengerCnt++;
                } while (true);
            }
            int answer = -1;
            Shuttle lastShuttle = shuttles.get(shuttles.size() - 1);
            if (lastShuttle.passengerCnt < m) {
                answer = lastShuttle.arrivalTime;
            } else {
                answer = lastShuttle.passengerArrivalTimes.last() - 1;
            }
            String hh = Integer.toString(answer / 60);
            String mm = Integer.toString(answer % 60);
            return (hh.length() == 1 ? "0" + hh : hh)
                    + ":"
                    + (mm.length() == 1 ? "0" + mm : mm);
        }

        private int toMinutes(String time) {
            String[] hm = time.split(":");
            return Integer.parseInt(hm[0]) * 60
                    + Integer.parseInt(hm[1]);
        }

        static class Shuttle {

            int arrivalTime;
            SortedSet<Integer> passengerArrivalTimes = new TreeSet<>();
            int passengerCnt = 0;

            Shuttle(int arrivalTime) {
                this.arrivalTime = arrivalTime;
            }

        }

    }

}
