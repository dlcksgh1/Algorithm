
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int newWeight = truck_weights[0];
        int time = 1;
        int truckOrder = 1;
        queue.offer(truck_weights[0]); // 1초시작
        while (!queue.isEmpty()) {

            if (truckOrder < truck_weights.length) {
                if (weight < (newWeight + truck_weights[truckOrder])) {
                    queue.offer(0);
                } else {
                    queue.offer(truck_weights[truckOrder]);
                    newWeight += truck_weights[truckOrder];
                    truckOrder++;
                }
            }
            time++;
            if (time >= bridge_length) {
                newWeight -= queue.poll();
            }
        }
        return time+1;
    }
}