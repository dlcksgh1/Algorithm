import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            int target = Integer.parseInt(br.readLine());
            String toBinary = Integer.toBinaryString(target);
            int n = toBinary.length();
            for (int j = n-1; j >=0; j--) {
                if (toBinary.charAt(j) == '1') {
                    sb.append(n-j-1+ " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

