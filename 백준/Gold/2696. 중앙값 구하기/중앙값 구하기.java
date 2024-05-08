import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int countCase = 0;
        StringBuilder sb = new StringBuilder();
        while (countCase < testCase) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            StringTokenizer st = null;
            sb.append(((n + 1) / 2) + "\n");
            int cnt = 0;
            for (int i = 0; i < n; i++) {

                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(Integer.parseInt(st.nextToken()));
                } else {
                    minHeap.offer(Integer.parseInt(st.nextToken()));
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int t1 = maxHeap.poll();
                        int t2 = minHeap.poll();

                        maxHeap.offer(t2);
                        minHeap.offer(t1);
                    }
                }

                if (i % 2 == 0) {
                    // 한 줄의 최대 10개만 가능.
                    if (cnt == 9 || i == n - 1) {
                        sb.append(maxHeap.peek() + "\n");
                        cnt = 0;
                    } else {
                        sb.append(maxHeap.peek() + " ");
                    }
                    cnt++;
                }
            }


            countCase++;
        }
        System.out.println(sb);
    }
}
