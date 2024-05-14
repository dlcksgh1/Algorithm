import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }

        sb = new StringBuilder();
        dfs(start, n);
        Arrays.fill(visited, false);
        sb.append("\n");
        bfs(start, n);
        System.out.println(sb);

    }

    private static void dfs(int start, int n) {

        sb.append(start + " ");
        visited[start] = true;
        for (int i = 0; i <= n; i++) {
            if (arr[start][i] == 1 && visited[i] == false) {
                dfs(i, n);
            }
        }
    }

    private static void bfs(int start, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        sb.append(start + " ");
        visited[start] = true;

        while (!queue.isEmpty()) {
            int newN = queue.poll();
            for (int i = 0; i <= n; i++) {
                if (arr[newN][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    sb.append(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
