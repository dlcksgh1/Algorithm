import java.util.*;
class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer ;
        int[] day = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            day[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) day[i]++;
        }
        int prev = day[0];
        int count = 1;
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 1;i < day.length; i++){
            if(prev < day[i]){
                prev = day[i];
                list.add(count);
                count = 1;
            }else{
                count++;
            }
        }
        list.add(count);
        
        answer = new int[list.size()];
        for(int i = 0;i <list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
}