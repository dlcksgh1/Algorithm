import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer>arr1=new ArrayList<>();
        arr1.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]!=arr[i]){
                arr1.add(arr[i]);
            }
        }
        int[] answer=new int[arr1.size()];
        for(int i=0;i<arr1.size();i++){
            answer[i]=arr1.get(i);
        }
        return answer;
    }
}