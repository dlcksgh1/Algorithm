/*
    queue를 사용하여 문제를 풀자
    다리의 길이만큼 queue에 값을 넣고 트럭을 올리지 못한다면 0을 넣어서 이동시켜준다.
    다리의 길이만큼 queue 가 쌓이면 큐에서 값을 빼준다.
*/

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0;
        for(int truck : truck_weights) {
            
            while(true) {
                if(bridge.isEmpty()) {
                    bridge.offer(truck);
                    currentWeight += truck;
                    time++;
                    break;
                } else if(bridge_length == bridge.size()) {
                       currentWeight -= bridge.poll();
                }else{
                    
                    if(currentWeight + truck <= weight) {
                        bridge.offer(truck);
                        currentWeight += truck;
                        time++;
                        break;
                    } else{
                        bridge.offer(0);
                        time++;
                    }
                }
            }
        }
                
        return time + bridge_length;
    }
}