import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list); // 이진탐색을 위한 정렬

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int result = binarySearch(Integer.parseInt(st.nextToken()), list);
            sb.append(result + "\n");
        }
        System.out.println(sb);

    }

    static int binarySearch(int n, ArrayList<Integer> list) {
        int start = 0;
        int end = list.size() -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == n) {
                return 1;
            } else if (list.get(mid) > n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}