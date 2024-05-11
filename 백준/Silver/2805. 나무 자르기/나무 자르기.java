import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int requiredCount = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            list.add(k);
            if (max < k) {
                max = k;
            }
        }
        Collections.sort(list);
        long result = binarySearch(requiredCount, list, 0,++max);

        System.out.println(result -1);
    }

    private static long binarySearch(int requiredCount, ArrayList<Integer> list, long min, long max) {

        while (min < max) {
            long mid = (min + max) / 2;
            long count = 0;
            for (int i = 0; i < list.size(); i++) {
                count += (list.get(i) - mid) > 0 ? list.get(i) - mid : 0;
            }

            if (count < requiredCount) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return  min;
    }
}
