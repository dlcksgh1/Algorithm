import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            // 1. i번째부터 j번째까지 자르기 (배열 인덱스는 0부터 시작하므로 -1 필요)
            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);

            // 2. 정렬
            Arrays.sort(slicedArray);

            // 3. k번째 값 추출 (배열 인덱스는 0부터 시작하므로 -1 필요)
            answer[c] = slicedArray[k - 1];
        }

        return answer;
    }
}