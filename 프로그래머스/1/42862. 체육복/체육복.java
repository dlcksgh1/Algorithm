import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    
        // 1. 겹치는 학생 제거
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        
        for (int l : lost) {
            lostSet.add(l);
        }
        for (int r : reserve) {
            if (lostSet.contains(r)) {
                lostSet.remove(r); // 자기 자신이 여벌을 가지고 있는 경우
            } else {
                reserveSet.add(r); // 실제 여벌이 있는 학생만 추가
            }
        }
        
        // 2. 빌려주기
        for (int r : new ArrayList<>(reserveSet)) {
            if (lostSet.contains(r - 1)) { // 앞번호 학생에게 빌려줌
                lostSet.remove(r - 1);
                reserveSet.remove(r);
            } else if (lostSet.contains(r + 1)) { // 뒷번호 학생에게 빌려줌
                lostSet.remove(r + 1);
                reserveSet.remove(r);
            }
        }

        // 3. 체육복을 가진 학생 수 계산
        return n - lostSet.size();
    }
}