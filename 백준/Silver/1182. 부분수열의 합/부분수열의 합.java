import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 조합문제 부분 수열을 전부 구하자
 */
public class Main {

    static int result = 0;
    static ArrayList<Integer> list;
    static int n, target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0); // 탐색 시작
        if (target == 0) result--; // 공집합 제외
        System.out.println(result);

    }
    static void dfs(int depth, int sum) {

        if(depth == n) {
            if(sum == target) result++;
            return;
        }

        dfs(depth + 1, sum + list.get(depth)); // 포함
        dfs(depth + 1, sum);  // 미포함
    }
}