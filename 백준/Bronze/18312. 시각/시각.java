
import java.io.*;
import java.util.*;

/**
 * 시, 분 초 를 확인하면됨
 * 시는 주어지는 숫자임 23 이하로 주어짐
 * 분은 59분 초도 59초
 * 즉 3중 for 문을 돌면서 확인하면 됨
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int h = 0; h <= n; h++) {
            for (int m = 0; m <= 59; m++) {
                for (int s = 0; s <= 59; s++) {
                    if (isCheck(h, m, s, k)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isCheck(int h, int m, int s, int k) {
        if (h % 10 == k || h / 10 == k || m % 10 == k || m / 10 == k || s % 10 == k || s / 10 == k) {
            return true;
        }
        return false;
    }
}
