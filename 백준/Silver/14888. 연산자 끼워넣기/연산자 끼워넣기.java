import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 주어진 숫자는 그대로 두고 연산자를 어떻게 선택할지 정하는 문제
 * N개의 수와 N-1 개의 연산자로 만들 수 있는 최대 최소 값 구하기
 */
public class Main {

    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n;
    static int[] numbers, operators;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void backtrack(int depth, int sum) {

        if(depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i] > 0 ){
                operators[i]--;
                switch (i){
                    case 0 : // 덧셈
                        backtrack(depth + 1, sum + numbers[depth]);
                        break;
                    case 1 : // 뻴셈
                        backtrack(depth + 1, sum - numbers[depth]);
                        break;
                    case 2 : // 곱셈
                        backtrack(depth + 1, sum * numbers[depth]);
                        break;
                    case 3 : // 나눗셈
                        backtrack(depth + 1, sum / numbers[depth]);
                        break;
                }
                operators[i]++;
            }
        }

    }


}
