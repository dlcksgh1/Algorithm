class Solution {
    
    static int result = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, target, 0, 0);
        
        return result;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum) {
        
        if(depth == numbers.length) {
            if(sum == target) {
                result++;
            }
            return;
        }
        
        dfs(numbers, target, depth + 1, sum + numbers[depth]);
        dfs(numbers, target, depth + 1, sum - numbers[depth]);
        
    }
}