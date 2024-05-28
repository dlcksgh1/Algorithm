import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        boolean[] is_prime = new boolean[end + 1];

        Arrays.fill(is_prime, true);
        is_prime[0] = false;
        is_prime[1] = false;
        int sum = 0;
        int min = end + 1;
        for (int i = 2; i <= Math.sqrt(end); i++) {
            if (is_prime[i]) {
                for (int j = i * i; j <= end; j = j + i) {
                    is_prime[j] = false;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (is_prime[i]) {
                sum += i;
                if (min > i) {
                    min = i;
                }
            }
        }
        if (sum > 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
