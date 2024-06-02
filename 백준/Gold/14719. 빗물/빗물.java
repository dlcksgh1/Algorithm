import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] higth = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            higth[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int i = 1; i < w - 1; i++) {
            int left =0, rigth = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(higth[j], left);
            }
            for (int j = i + 1; j < w; j++) {
                rigth = Math.max(higth[j], rigth);
            }

            if (higth[i] < left && higth[i] < rigth) {
                result += Math.min(left, rigth) - higth[i];
            }
        }
        System.out.println(result);
    }
}
