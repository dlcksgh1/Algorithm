class Solution {
    public int solution(String name) {
        int length = name.length();
        int upDownCount = 0; // 상하 조작 횟수
        int minMove = length - 1; // 좌우 이동 최소 횟수 (기본적으로 끝까지 이동하는 경우)

        for (int i = 0; i < length; i++) {
            // 상하 조작 횟수 계산
            char c = name.charAt(i);
            upDownCount += Math.min(c - 'A', 'Z' - c + 1);

            // 좌우 조작 횟수 최적화
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++; // 연속된 'A' 건너뛰기
            }

            // 최적 이동 계산
            int move = i + length - nextIndex + Math.min(i, length - nextIndex);
            minMove = Math.min(minMove, move);
        }

        return upDownCount + minMove;
    }
}