import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0, len = Integer.MAX_VALUE;
        while (start <= n && end <= n) {

            if (sum >= s) {
                len = Math.min(len, end - start);
                sum -= arr[start++];
            } else if(sum < s) {
                sum += arr[end++];
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
