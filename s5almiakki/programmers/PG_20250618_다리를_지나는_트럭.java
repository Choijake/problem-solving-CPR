import java.util.*;

public class PG_20250618_다리를_지나는_트럭 {

    class Solution {

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Bridge bridge = new Bridge(bridge_length, weight);
            Deque<Truck> pendingTrucks = new ArrayDeque<>();
            for (int truckWeight : truck_weights) {
                pendingTrucks.add(new Truck(truckWeight, 0));
            }
            int second = 0;
            while (!bridge.isEmpty() || !pendingTrucks.isEmpty()) {
                second++;
                bridge.moveTrucks();
                if (pendingTrucks.isEmpty()) {
                    continue;
                }
                if (!bridge.isEnterable(pendingTrucks.element())) {
                    continue;
                }
                bridge.enter(pendingTrucks.remove());
            }
            return second;
        }

        static class Bridge {

            private int bridgeLength;
            private int weightLimit;
            private int weightSum = 0;
            private Deque<Truck> truckQueue = new ArrayDeque<>();

            public Bridge(int bridgeLength, int weightLimit) {
                this.bridgeLength = bridgeLength;
                this.weightLimit = weightLimit;
            }

            public void enter(Truck truck) {
                this.truckQueue.add(truck);
                truck.move();
                weightSum += truck.getWeight();
            }

            public boolean isEnterable(Truck truck) {
                return (this.weightLimit - this.weightSum) >= truck.getWeight();
            }

            public void moveTrucks() {
                if (this.isEmpty()) {
                    return;
                }
                for (Truck truck : truckQueue) {
                    truck.move();
                }
                if (isOut(truckQueue.element())) {
                    weightSum -= truckQueue.remove().getWeight();
                }
            }

            private boolean isOut(Truck truck) {
                return truck.getPosition() > this.bridgeLength;
            }

            public boolean isEmpty() {
                return this.truckQueue.isEmpty();
            }

        }

        static class Truck {

            private int weight;
            private int position;

            public Truck(int weight, int position) {
                this.weight = weight;
                this.position = position;
            }

            public void move() {
                this.position++;
            }

            public int getWeight() {
                return this.weight;
            }

            public int getPosition() {
                return this.position;
            }

        }

    }

}
