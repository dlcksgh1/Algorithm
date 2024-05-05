import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int su = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        bfs(su, bro);
        System.out.println(visited[bro]-1);

    }

    private static void  bfs(int su, int bro) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(su);
        visited[su] = 1;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int[] dx = {x -1, x + 1, 2 * x};
            if (x == bro) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                if (0 <= dx[i] && dx[i] < 100001 && visited[dx[i]] ==0) {
                    visited[dx[i]] = visited[x] + 1;
                    queue.offer(dx[i]);
                }
            }
        }
    }


}
