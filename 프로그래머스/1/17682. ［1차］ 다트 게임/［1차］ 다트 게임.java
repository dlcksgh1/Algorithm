class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3]; // 점수를 저장할 배열
        int index = 0; // 현재 점수의 인덱스

        int len = dartResult.length();
        for (int i = 0; i < len; i++) {
            char c = dartResult.charAt(i);

            // 숫자인 경우
            if (Character.isDigit(c)) {
                int num;
                if (c == '1' && i + 1 < len && dartResult.charAt(i + 1) == '0') {
                    // "10" 처리
                    num = 10;
                    i++; // 10은 두 자릿수이므로 하나 더 읽음
                } else {
                    num = c - '0';
                }
                scores[index] = num; // 점수 저장
            }

            // 보너스인 경우
            else if (c == 'S' || c == 'D' || c == 'T') {
                if (c == 'S') {
                    scores[index] = (int) Math.pow(scores[index], 1);
                } else if (c == 'D') {
                    scores[index] = (int) Math.pow(scores[index], 2);
                } else if (c == 'T') {
                    scores[index] = (int) Math.pow(scores[index], 3);
                }
                index++; // 보너스 적용 후 다음 점수로 이동
            }

            // 옵션인 경우
            else if (c == '*' || c == '#') {
                if (c == '*') {
                    // 현재 점수 2배
                    scores[index - 1] *= 2;
                    // 이전 점수도 존재하면 2배
                    if (index - 2 >= 0) {
                        scores[index - 2] *= 2;
                    }
                } else if (c == '#') {
                    // 현재 점수 마이너스
                    scores[index - 1] *= -1;
                }
            }
        }

        // 최종 점수 합산
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }

        return totalScore;
    }
}