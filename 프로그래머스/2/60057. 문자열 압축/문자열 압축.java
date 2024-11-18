
/*
* 문제를 보면 문자열을 압축해서 그 압출률이 가장 큰 것(문자열이 가장 짧은 것의 길이) 
* 를 구하는 문제이다.
* 생각을 해보면 2 ~ n /2 만큼 까지 압축해보자
*/
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= s.length()/2; i++ ) { // 1 ~ n/2 까지 압축
            
            String compare = s.substring(0, i);
            String temp;
            StringBuilder result = new StringBuilder();
            int cnt = 1;
            for(int j = i; j <= s.length(); j+=i) { 

                int endIdx = Math.min(j + i, s.length());
                
                temp = s.substring(j, endIdx);
                if(temp.equals(compare)) {
                    cnt++;
                } else {
                    if(cnt >= 2 ) { // 중복되는 값이 있다면 
                        result.append(cnt);
                    } 
                    result.append(compare);
                    
                    compare = temp;
                    cnt = 1;
                }
            }
            if (cnt >= 2) {
                result.append(cnt);
            }
            result.append(compare);
            
            answer = Math.min(answer, result.length());
        }
        
        return Math.min(answer, s.length());
    }
}