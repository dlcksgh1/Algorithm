import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 미로찾기 (BFS) 사용하여 구현
 * BFS 를 사용하여 넓이우선탐색을 진행하여 1여부 판단 후 이전 node 에서 cnt++
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] arr = new int[x][y];
        int[][] visited = new int[x][y];

        // 배열 초기화
        for (int i = 0; i < x; i++) {
            String str = br.readLine();
            for (int j = 0; j < y; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }



        int result = bfs(arr, visited);
        System.out.println(result);
    }

    private static int bfs(int[][] arr, int[][] visited) {
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(new Node3(0, 0));
        visited[0][0] = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            Node3 node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < arr.length && 0 <= newY && newY < arr[0].length) {
                    if (visited[newX][newY] == 0 && arr[newX][newY] == 1) {
                        queue.offer(new Node3(newX, newY));
                        visited[newX][newY] = visited[x][y] + 1;
                    }
                }
            }
        }

        return visited[arr.length - 1][arr[0].length - 1];
    }

}

class Node3 {
    private int x;
    private int y;

    public Node3(int x, int y) {
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