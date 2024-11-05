import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // N 입력
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 보상
        int[] dp = new int[N + 2]; // dp[i]: i일 이후 최대 수익

        // T와 P 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp 계산
        for (int i = N; i > 0; i--) {
            if (i + T[i] <= N + 1) {
                dp[i] = Math.max(P[i] + dp[i + T[i]], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1]; // 일정이 끝날 날을 초과하면 선택할 수 없음
            }
        }

        // 결과 출력
        System.out.println(dp[1]);
    }
}
