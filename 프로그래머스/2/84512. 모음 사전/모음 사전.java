import java.util.*;

class Solution {
    
    static String VOWELS = "AEIOU";
    static List<String> dictionary = new ArrayList<>();
    
    public int solution(String word) {
        generateWords("", 0); // 모든 단어 생성
        Collections.sort(dictionary); // 사전 순 정렬
        return dictionary.indexOf(word) + 1; // 단어의 순서 반환
    }

    // 단어 생성 함수
    public void generateWords(String current, int depth) {
        if (depth == 5) return; // 최대 5글자까지만 생성
        for (int i = 0; i < VOWELS.length(); i++) {
            String nextWord = current + VOWELS.charAt(i);
            dictionary.add(nextWord); // 단어 추가
            generateWords(nextWord, depth + 1); // 재귀 호출
        }
    }
}