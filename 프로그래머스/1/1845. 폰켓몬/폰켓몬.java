

import java.util.*;
class Solution {
    public int solution(int[] nums) {
        // 1. Set을 이용해 포켓몬 종류 계산
        Set<Integer> uniquePokemons = new HashSet<>();
        for (int num : nums) {
            uniquePokemons.add(num);
        }

        // 2. 선택 가능한 포켓몬 수
        int maxPick = nums.length / 2;

        // 3. 포켓몬 종류 수와 선택 가능한 수 중 작은 값을 반환
        return Math.min(uniquePokemons.size(), maxPick);
    }
}