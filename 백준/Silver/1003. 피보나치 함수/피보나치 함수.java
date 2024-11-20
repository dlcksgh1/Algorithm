import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 이 문제는 fi(0), fi(1) 이 몇번 호출 되는지를 묻는 문제
 * dp 사용해서 풀어보자
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int[][] dp = new int[2][41];
        dp[0][0] = 1;
        dp[1][1] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 2; i <= 40; i++) {
            dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
            dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
        }

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[0][n] + " " + dp[1][n]);
        }
    }
}
