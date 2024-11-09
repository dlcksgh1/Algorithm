import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int cnt = 0; cnt < t; cnt++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m+1];
            for (int i = 0; i < n; i++) {
                int coin = Integer.parseInt(st.nextToken());
                for (int j = coin; j <= m; j++) {
                    if(j==coin){
                        dp[j] += 1;
                    } else {
                        dp[j] = dp[j] + dp[j- coin];
                    }
                }
            }
            System.out.println(dp[m]);
        }
    }
}