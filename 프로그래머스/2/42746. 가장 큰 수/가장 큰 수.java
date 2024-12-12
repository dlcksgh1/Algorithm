import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]); 
        }
        
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // a + b와 b + a를 비교
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // 내림차순 정렬
            }
        });
        
        // 3. 정렬된 결과를 하나의 문자열로 결합
        String result = String.join("", strNumbers);

        // 4. 예외 처리: 모든 숫자가 0인 경우
        if (result.startsWith("0")) {
            return "0";
        }

        return result;

    }
}