import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[123]; // 소문자 a가 97 z 가 122이기 때문에 123 까지 할당
        Arrays.fill(cnt, -1); //  전체 초기화
        for (int i = 0; i < str.length(); i++) {
            char k = str.charAt(i);
            if (cnt[k] == -1) {
                cnt[k] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 97; i <= 122; i++) {
            sb.append(cnt[i] + " ");
        }
        System.out.println(sb);
        
    }

}
