
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        while(cnt > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visited = new boolean[m][n];
            for(int i = 0 ; i < k ; i ++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            int count = 0;

            for(int i = 0 ; i < m ; i ++){
                for(int j = 0 ; j < n ; j++){
                    if(!visited[i][j] && arr[i][j] != 0){
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
            cnt--;
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        int[] X = {0, 0, -1 ,1};
        int[] Y = {-1, 1, 0, 0};

        for(int i = 0 ; i < 4 ; i ++){
            int kx = x + X[i];
            int ky = y + Y[i];

            if(kx < 0 || kx >= m || ky < 0 || ky >= n ){
                continue;
            }

            if(!visited[kx][ky] && arr[kx][ky] != 0){
                dfs(kx, ky);
            }
        }
    }
}