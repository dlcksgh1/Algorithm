import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[][] map;
    static int n;
    static int m;
    static int u;
    static int v;
    static int result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            map[u][v] = 1;
            map[v][u] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i = 1; i <= n; i++) {
            if (map[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}