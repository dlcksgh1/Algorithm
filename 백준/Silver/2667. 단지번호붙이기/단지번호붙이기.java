import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        // 배열 초기화
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        // 전체에 대히여 bfs 돌리기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int cnt = bfs(arr, visited, i, j);
                    list.add(cnt);
                    count++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(list.get(i));
        }
    }

    private static int bfs(int[][] arr, boolean[][] visited,int i, int j) {
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(new Node3(i, j));
        visited[i][j] = true;
        int cnt = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            Node3 node = queue.poll();
            int x = node.getX();
            int y = node.getY();
            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (0 <= newX && newX < arr.length && 0 <= newY && newY < arr[0].length && !visited[newX][newY] && arr[newX][newY] == 1) {
                    queue.offer(new Node3(newX, newY));
                    visited[newX][newY] = true;
                    cnt++;
                }
            }
        }
        return cnt;

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
