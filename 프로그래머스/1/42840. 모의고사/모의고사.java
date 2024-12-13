
/*
    •	1번, 2번, 3번 수포자가 각각 일정한 방식으로 정답을 찍습니다.
	•	주어진 답안과 수포자들의 답안을 비교하여 가장 많은 문제를 맞힌 수포자를 구합니다.
	•	가장 많이 맞힌 수포자가 여러 명일 경우, 오름차순으로 정렬하여 반환합니다.

*/

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = new int[3];
        
        for(int i = 0 ; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) scores[0]++;
            if (answers[i] == pattern2[i % pattern2.length]) scores[1]++;
            if (answers[i] == pattern3[i % pattern3.length]) scores[2]++;
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> topScorers = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                topScorers.add(i + 1); // 수포자는 1번부터 시작
            }
        }
        
        int[] answer = new int[topScorers.size()];
        for(int i = 0 ; i < topScorers.size(); i++) {
            answer[i] = topScorers.get(i);
        }
        
        
        return answer;
    }
}