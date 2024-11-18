class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 0 ~ 9 까지 좌표 선언
        int[][] keypad = {
            {3 ,1}, // 0
            {0 ,0}, {0 ,1}, {0 ,2}, // 1 2 3
            {1 ,0}, {1, 1}, {1, 2}, // 4 5 6
            {2, 0}, {2, 1}, {2, 2}  // 7 8 9
        };
        
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        StringBuilder sb = new StringBuilder();
        
        for(int num : numbers) {
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = keypad[num];
            } else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = keypad[num];
            } else {
                int leftDist = calDist(leftPos, keypad[num]);
                int rightDist = calDist(rightPos, keypad[num]);
                if(leftDist > rightDist) {
                    sb.append("R");
                    rightPos = keypad[num];
                }else if(leftDist < rightDist) {
                    sb.append("L");
                    leftPos = keypad[num];
                } else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        leftPos = keypad[num];                        
                    } else {
                        sb.append("R");
                        rightPos = keypad[num]; 
                    }
                }
            }
            
        }
        return sb.toString();
    }
    
    public static int calDist(int[] pos, int[] keypad) {
        return Math.abs(pos[0] - keypad[0]) + Math.abs(pos[1] - keypad[1]);
    }
}