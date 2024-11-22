import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        
        int t = bandage[0]; // 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량
        
        // 공격 정보를 Map에 저장
        Map<Integer, Integer> attackMap = new HashMap<>();
        for (int[] attack : attacks) {
            attackMap.put(attack[0], attack[1]);
        }

        int consecutiveTime = 0; // 붕대를 연속으로 감은 시간
        int maxHealth = health;  // 최대 체력 제한
        int lastAttackTime = attacks[attacks.length - 1][0];
        
        for (int time = 1; time <= lastAttackTime; time++) {
            if (attackMap.containsKey(time)) {
                // 공격 발생: 체력 감소
                health -= attackMap.get(time);

                if (health <= 0) {
                    return -1; // 캐릭터 사망
                }

                // 붕대 감기 실패
                consecutiveTime = 0;
            } else {
                // 붕대를 감는 중: 체력 회복
                consecutiveTime++;
                health += x; // 초당 회복량

                if (consecutiveTime == t) {
                    // 붕대를 완전히 감았으므로 추가 회복
                    health += y;
                    consecutiveTime = 0; // 초기화
                }

                if (health > maxHealth) {
                    health = maxHealth; // 최대 체력 초과 방지
                }
            }
        }

        return health; // 최종 남은 체력 반환
    }
}
