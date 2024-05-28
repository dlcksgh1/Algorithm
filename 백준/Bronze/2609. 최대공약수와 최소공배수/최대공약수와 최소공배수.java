import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대공약수를 구하기위한 gcd
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());


        int result = gcd(s1, s2);
        System.out.println(result);
        System.out.println((s1 * s2) / result);
    }

    static int gcd(int s1, int s2) {

        while (s2 != 0) {
            int temp = s1 % s2;
            s1 = s2;
            s2 = temp;
        }
        return s1;
    }

}
