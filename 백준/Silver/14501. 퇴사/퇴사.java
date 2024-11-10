import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 퇴사까지 남은 일 수
        int[] T = new int[N + 1];  // 각 상담에 걸리는 일 수
        int[] P = new int[N + 1];  // 각 상담의 수익
        int[] dp = new int[N + 2]; // 최대 수익을 저장할 dp 배열 (퇴사일을 넘어서 인덱스 사용)

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            // 현재 일자에서 얻을 수 있는 수익을 다음 날로 갱신
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 상담이 퇴사 전까지 끝나는 경우
            if (i + T[i] <= N + 1) {
                dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]); // 퇴사일에 최대 수익 출력
        sc.close();
    }
}
