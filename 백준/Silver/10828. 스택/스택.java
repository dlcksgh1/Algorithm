import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) {
                case "push":
                    int input = Integer.parseInt(st.nextToken());
                    stack.add(input);
                    break;
                case "pop" :
                    if (stack.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.get(stack.size()-1));
                        stack.remove(stack.size()-1);
                    }
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    if (stack.size() == 0) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top" :
                    if (stack.size() == 0) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.get(stack.size()-1));
                    }
                    break;
            }
        }
    }
}
