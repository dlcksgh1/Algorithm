import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] computers;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        computers = new int[n][n];
        visited = new boolean[n];
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < cnt; i++) { // computer 세팅
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computers[x - 1][y - 1] = 1;
            computers[y - 1][x - 1] = 1;
        }

        int size = bfs(0, n);
        System.out.println(size);
    }

    private static int bfs(int a, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        visited[a] = true;

        int size = 0;
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int i = 0; i < n; i++) {
                if (!visited[i] && computers[w][i] == 1) {
                    size++;
                    queue.offer(i);
                    visited[i] = true;
                }
            }


        }

        return size;
    }
}
