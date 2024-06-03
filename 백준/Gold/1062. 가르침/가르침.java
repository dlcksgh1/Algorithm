import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * backtracking과 조합을 사용하여 문제를 풀자
 */
public class Main {

    static boolean[] visited;
    static String[] arr;
    static int max = Integer.MIN_VALUE;
    static int n , k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        if (k < 5) {
            System.out.println(0);
        } else {
            visited = new boolean[26];
            arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }
            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;
            backTracking(0, 0);
            System.out.println(max);
        }

    }

    static void backTracking(int depth, int alpha) {

        if (depth == k - 5) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                boolean check = true;
                for (int j = 0; j < arr[i].length(); j++) {
                    if (!visited[arr[i].charAt(j) - 'a']) {

                        check = false;
                        break;
                    }
                }
                if (check) {
                    cnt++;
                }
            }
            if (max < cnt) max = cnt;
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
