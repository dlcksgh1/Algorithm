import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                Stack<String> stack = new Stack<>();
                for (int j = 0; j < str.length(); j++) {
                    stack.push(Character.toString(str.charAt(j)));
                }
                for (int j = 0; j < str.length(); j++) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
            System.out.println(sb);

        }
    }
}
