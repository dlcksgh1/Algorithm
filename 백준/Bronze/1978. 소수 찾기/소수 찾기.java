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
            boolean is_prime = true;
            if (k != 1) {
                for (int j = 2; j <= Math.sqrt(k); j++) {
                    if (k % j == 0) {
                        is_prime = false;
                        break;
                    }
                }
                if(is_prime) cnt++;
            }
        }
        System.out.println(cnt);
        
    }
}
