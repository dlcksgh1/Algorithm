import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1000001, max = -1000001;
        for (int i = 0; i < cnt; i++) {
            int next = Integer.parseInt(st.nextToken());
            min = (min > next) ?  next : min;
            max = (max < next) ? next : max;
        }
        System.out.println(min + " " + max);
    }
}
