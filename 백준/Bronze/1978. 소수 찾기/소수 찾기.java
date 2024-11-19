import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            if(isPrime(k)) cnt++;
        }
        System.out.println(cnt);
    }
    static boolean isPrime(int n) {
        if(n <= 1) return false;
        for (int i = 2; i * i <= n ; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}