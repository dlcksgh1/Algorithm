import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String str = br.readLine();
            Stack<Integer> stack = new Stack<>();
            boolean validPS = true;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push(1);
                } else {
                    if (stack.empty()) {
                        validPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (validPS && stack.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
