import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
               
        // 1. 전화번호 목록 정렬
        Arrays.sort(phone_book);
        // 2. 인접한 전화번호끼리 접두어 관계인지 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 현재 번호가 다음 번호의 접두어인지 확인
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false; // 접두어 관계가 있으면 false 반환
            }
        }

        return true; // 접두어 관계가 없으면 true 반환
    }
}