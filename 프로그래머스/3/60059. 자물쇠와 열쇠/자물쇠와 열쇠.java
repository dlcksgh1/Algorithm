class Solution {
    
    public static int[][] rotate(int[][] key) {
        int n = key.length;
        int m = key[0].length;
        
        int[][] newkey = new int[m][n];
        
        for(int i = 0; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                newkey[i][j] = key[n-1-j][i];
            }
        }
        
        return newkey;
    }
    
    public static boolean check(int[][] lock, int n){
        for(int i = n; i <2*n; i++){
            for(int j = n; j <2*n; j++){
                if(lock[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        
        int n = lock.length;
        int m = key.length;
        
        // 새로운 자물쇠 중간에 자물쇠 넣기
        int[][] newlock = new int[3*n][3*n];
        for(int i = 0 ; i < n; i++ ) {
            for(int j = 0 ; j < n; j++) {
                newlock[n + i][n + j] = lock[i][j];
            }
        }
        
        
        
        for(int ro = 0; ro < 4 ; ro++) {
            key = rotate(key);
            for(int x = 0 ; x < 2*n; x++) {
                for(int y = 0 ; y < 2*n; y++) {

                    for(int i = 0; i < m ; i++) {
                        for(int j = 0 ; j < m ; j++) {
                            newlock[x+i][y+j] += key[i][j];
                        }
                    }

                    if(check(newlock, n)) return true;

                    for(int i = 0; i < m ; i++) {
                        for(int j = 0 ; j < m ; j++) {
                            newlock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        
        
        
        return false;
    }
}