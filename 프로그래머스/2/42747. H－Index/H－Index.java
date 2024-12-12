

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {        
        Arrays.sort(citations);
        int n = citations.length;

        // 2. H-Index 계산
        for (int i = 0; i < n; i++) {
            int h = n - i; // 남아 있는 논문의 수
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0; // H-Index가 없는 경우
    }
}