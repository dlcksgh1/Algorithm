import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int edX;
    static int edY;
    static Queue<NodeTest> queue;
    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (testCase > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            visited = new boolean[n][n];
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int stX = Integer.parseInt(st.nextToken());
            int stY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            edX = Integer.parseInt(st.nextToken());
            edY = Integer.parseInt(st.nextToken());
            visited[stX][stY] = true;
            queue.offer(new NodeTest(stX, stY));
            bfs();
            System.out.println(arr[edX][edY]);
            testCase--;
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            NodeTest node = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = node.getX() + dx[i];
                int newY = node.getY() + dy[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < n && !visited[newX][newY]) {
                    arr[newX][newY] = arr[node.getX()][node.getY()] + 1;
                    visited[newX][newY] = true;
                    if (newX == edX && newY == edY) {
                        return;
                    }
                    queue.offer(new NodeTest(newX, newY));
                }
            }
        }
    }
}

class NodeTest {
    private int x;
    private int y;

    public NodeTest(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
