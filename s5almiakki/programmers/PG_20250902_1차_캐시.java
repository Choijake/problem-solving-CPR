import java.util.*;

public class PG_20250902_1차_캐시 {

    class Solution {

        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) {
                return cities.length * 5;
            }
            PriorityQueue<CacheData> pq = new PriorityQueue<>();
            int currentTime = 0;
            for (String city : cities) {
                city = city.toLowerCase();
                if (pq.isEmpty()) {
                    pq.add(new CacheData(city, currentTime));
                    currentTime += 5;
                    continue;
                }
                CacheData cacheData = null;
                for (CacheData cd : pq) {
                    if (cd.city.equals(city)) {
                        cacheData = cd;
                        pq.remove(cd);
                        break;
                    }
                }
                if (cacheData != null) {
                    cacheData.lastUsedTime = currentTime;
                    pq.add(cacheData);
                    currentTime++;
                    continue;
                }
                cacheData = new CacheData(city, currentTime);
                currentTime += 5;
                if (pq.size() == cacheSize) {
                    pq.remove();
                }
                pq.add(cacheData);
            }
            return currentTime;
        }

        private static class CacheData implements Comparable<CacheData> {

            String city;
            int lastUsedTime;

            public CacheData(String city, int lastUsedTime) {
                this.city = city;
                this.lastUsedTime = lastUsedTime;
            }

            @Override
            public int compareTo(CacheData o) {
                return this.lastUsedTime - o.lastUsedTime;
            }

        }

    }

}
