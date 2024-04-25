import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine();
        String after = convert(before);
        System.out.println(after);
    }

    public static String convert(String before) {
        String after = "";
        for (int i = 0; i < before.length(); i++) {
            int k = before.charAt(i);
            k -= 3;
            if (k < 65) {
                k += 26;
            }
            after += Character.toString((char) k);
        }

        return after;
    }
}
