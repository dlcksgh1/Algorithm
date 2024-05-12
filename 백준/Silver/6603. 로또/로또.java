import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(arr, visited, 0, 0);
            System.out.println();
        }

    }

    private static void dfs(int[] arr, boolean[] visited, int depth, int start) {
        if (depth == 6) {
            print(arr.length, visited, arr);
        }
        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            dfs(arr, visited, depth + 1, i+1);
            visited[i] = false;
        }
    }

    private static void print(int n, boolean[] visited, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(arr[i] + " ");
            }
        }
        System.out.println(sb);
    }
}
