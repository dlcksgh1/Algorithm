/*
    brown, yellow 색상이 주어진다
    1. total =  brown + yellow 
    2. 가로가 세로보다 크거나 같기떼문에 세로를 기준으로 작은수부터 시작하면 무조건 가로가 큼
    3. brown 값은 가로 * 2 + (세로 -2) *2 
    4. yellow 는 (가로 -2) * (세로 -2)
    5. 가로 세로는 무조건 3 이상임

*/

class Solution {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        for(int height = 3; height <= total / 3; height++) {
            int width = total / height;
            if(((width * 2) + (height - 2) * 2) == brown) {
                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height}; // 조건을 모두 만족하면 반환
                }
            }
            
        }
        
        
        return new int[0];
    }
}