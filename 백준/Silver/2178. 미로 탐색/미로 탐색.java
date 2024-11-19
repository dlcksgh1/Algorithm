import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * bfs로 풀거임
 * 해당 문제는 visited 여부 필요 없이 1 인 곳을 갈건데 방문하면
 * 그 해당 칸에 몇번째로 이동했는지에 대한 값을 넣을거임
 */
public class Main {

    static int[][] map;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();

        System.out.println(map[n-1][m-1]);


    }

    public static void bfs(){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || nx >=n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == 1 ){
                    map[nx][ny] = map[node.x][node.y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

    }
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
