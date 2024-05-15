import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static Queue<Tomato> queue = new LinkedList<>();
    static int m;
    static int n;


    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        // 배열 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }

            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        int day = 0;
        while (!queue.isEmpty()) {
            Tomato t = queue.poll();
            day = t.getDay();
            for (int i = 0; i < 4; i++) {
                int newX = t.getX() + dx[i];
                int newY = t.getY() + dy[i];
                if (0 <= newX && newX < n && 0 <= newY && newY < m  && arr[newX][newY] == 0) {
                    arr[newX][newY] = 1;
                    queue.offer(new Tomato(newX, newY, day + 1));
                }
            }
        }

        return (checkTomato()) ? day : -1;
    }

    static boolean checkTomato() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
class Tomato {
    private int x;
    private int y;
    private int day;

    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDay() {
        return day;
    }
}
