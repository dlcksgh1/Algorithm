import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] days, costs, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        days = new int[n+1];
        costs = new int[n+1];
        dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            days[i] = day;
            costs[i] = cost;
        }
        Arrays.fill(dp, 0);

        for (int i = 1; i <= n; i++) {
            int day = days[i];
            int cost = costs[i];
            if(i + (day -1) > n) continue;
            int start = i+day-1;
            for (int j = start; j <= n ; j++) {
                dp[j] = Math.max(dp[j], dp[i-1] + cost);
            }
        }
        System.out.println(dp[n]);

    }
}
