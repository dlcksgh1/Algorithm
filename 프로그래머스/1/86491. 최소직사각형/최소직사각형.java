/*
    가로 세로의 길이가 주어진다 

*/


class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxLength = 0;
        
        for(int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int length = Math.min(size[0], size[1]);
            
            
            maxWidth = Math.max(maxWidth, width);
            maxLength = Math.max(maxLength, length);
        }
        
        return maxWidth * maxLength;
        
    }
}