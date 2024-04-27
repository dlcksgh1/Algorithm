import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        double newSum = 0;
        for (int i = 0; i < cnt; i++) {
            int next = Integer.parseInt(st.nextToken());
            list.add(next);
        }
        Collections.sort(list);
        int max = list.get(cnt - 1);
        for (int i = 0; i < cnt ; i++) {
            newSum +=  ((double)list.get(i)/ (double)max) * 100;
        }
        //newSum += max;
        System.out.println(newSum / (double)cnt);

    }
}
