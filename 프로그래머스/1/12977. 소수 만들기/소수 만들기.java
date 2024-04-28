class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int i = 0 ; i < nums.length; i++){
            
            for(int j = i+1; j < nums.length; j++){
                
                for(int k = j+1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                                    
                    if(isPrime(sum)) {
                        answer ++;
                    }
                    
                }
                
            }
            
        }

        return answer;
    }
    
    public boolean isPrime(int sum) {
        
        for(int i = 2; i <=Math.sqrt(sum); i++) {
            if(sum % i == 0) {
                return false;
            }
        }
        return true;
        
    }
}


/**
 * 에라토스 테네스 의 체
public class prime {
    public static void main(String[] args) {
        int target = 100;

        boolean[] isPrime = new boolean[101];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(target) ; i++) {
            if (isPrime[i]) {

                for (int j = i * i; j <= target; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i <= target; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}

 */
