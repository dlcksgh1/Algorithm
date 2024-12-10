import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        
        // 1. HashMap으로 의상 종류별 개수 저장
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 의상 종류
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 2. 조합 계산
        int answer = 1;
        for (int count : map.values()) {
            answer *= (count + 1); // 각 종류에서 선택하지 않는 경우 포함
        }

        return answer - 1; // 아무것도 입지 않는 경우 제외
    }
}