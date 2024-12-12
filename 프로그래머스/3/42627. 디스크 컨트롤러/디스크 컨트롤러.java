import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 1. 작업을 요청 시간 기준으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // 요청 시간 기준 오름차순
            }
        });

        // 2. 우선순위 큐 (작업 소요 시간이 짧은 순서로 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1]; // 작업 소요 시간 기준 오름차순
            }
        });

        int currentTime = 0; // 현재 시간
        int totalTime = 0;   // 총 소요 시간
        int index = 0;       // jobs 배열의 인덱스
        int completedJobs = 0; // 처리 완료된 작업 수

        while (completedJobs < jobs.length) {
            // 3. 현재 시간까지 요청된 작업을 우선순위 큐에 추가
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                pq.add(jobs[index]);
                index++;
            }

            if (pq.isEmpty()) {
                // 4. 큐가 비어 있으면 다음 작업 요청 시간으로 이동
                currentTime = jobs[index][0];
            } else {
                // 5. 작업 처리
                int[] job = pq.poll();
                currentTime += job[1]; // 작업 소요 시간만큼 진행
                totalTime += (currentTime - job[0]); // 대기 시간 포함
                completedJobs++;
            }
        }

        // 6. 평균 시간 계산
        return totalTime / jobs.length;
    }
}