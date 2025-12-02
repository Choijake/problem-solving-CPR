import java.util.*;

class PG_시소짝궁 {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        long count = 0;

        double[] ratios = {1.0, 2.0/3.0, 2.0/4.0, 3.0/4.0};
        for(int w : weights){
            for(double r : ratios){
                double key = w*r;
                if(map.containsKey(key)){
                    count += map.get(key);
                }
            }

            map.put((double)w, map.getOrDefault((double)w, 0)+1);
        }

        return count;
    }
}