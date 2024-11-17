/*
    일단 - stack을 사용할거임
    그리고 그 전에 인형뽑기 할 때 위에서 아래로
*/
import java.util.*;
//import java.io.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < moves.length; i++) {
            int move = moves[i];
            int temp = 0;
            for(int j = 0; j < board.length; j++) {
                if(board[j][move-1] != 0) {
                    temp = board[j][move-1];
                    System.out.println("테스트" + temp);
                    board[j][move-1] = 0;
                    break;
                }
            }
            
            System.out.println("temp" + temp);
            if(temp != 0) {
                if(!st.isEmpty()){
                    int temp2 = st.peek();
                    System.out.println("비교1" + temp);
                    System.out.println("비교2" + temp2);
                    if(temp2 == temp) {
                        st.pop();
                        answer += 2;
                    } else {
                        st.push(temp);
                    }
                } else {
                    st.push(temp);
                }

            }
        }
        return answer;
    }
}