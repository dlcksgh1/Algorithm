import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {

            for (int i = 1; i < target; i++) {
                queue.offer(queue.poll());
            }
            list.add(queue.poll());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i) + ", ");
        }
        sb.append(list.get(list.size() -1)+">");
        System.out.println(sb);
    }
}
