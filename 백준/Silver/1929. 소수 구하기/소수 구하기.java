import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for (int i = start; i <= end; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }

    static boolean isPrime(int n) {
        if(n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
