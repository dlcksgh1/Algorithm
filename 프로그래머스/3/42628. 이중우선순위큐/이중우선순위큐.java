import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        
        // 최소 힙과 최대 힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                // 삽입 연산
                minHeap.add(number);
                maxHeap.add(number);
            } else if (command.equals("D")) {
                if (minHeap.isEmpty()) continue; // 큐가 비어있으면 삭제 무시

                if (number == 1) {
                    // 최댓값 삭제
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (number == -1) {
                    // 최솟값 삭제
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        // 최종 결과 반환
        if (minHeap.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }
}