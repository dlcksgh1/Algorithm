import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static boolean[] visited  = new boolean[9];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        find(0, 0);
    }

    static void find(int depth, int start) {
        if (depth == 7) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                if (visited[i]) {
                    sb.append(list.get(i) + "\n");
                    sum += list.get(i);
                }
            }
            if (sum == 100) {
                System.out.println(sb.toString());
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                find(depth + 1, i);
                visited[i] = false;
            }
        }

    }
}
