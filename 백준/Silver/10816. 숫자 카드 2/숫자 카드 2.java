import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 *  해당 문제를 풀기위해선 이진탐색을 커스텀 해야한다.
 *  key 값 보다 작은값, 키값보다 큰값읋 찾을 수 있도록
 *  또한 start 값을 return 하도록
 */
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
            int target = Integer.parseInt(st.nextToken());
            int cnt = upperBound(target, list, 0, list.size()) - lowerBound(target, list, 0, list.size());
            sb.append(cnt + " ");
        }
        System.out.println(sb);


    }

    static int lowerBound(int target, ArrayList<Integer> list, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int upperBound(int target, ArrayList<Integer> list, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (target < list.get(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
