import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 별찍기(1) - N번째 줄에 N개의 별을 찍기
 * 1. Scanner 사용하여 입력값 받는경우
 * 2. BufferedReader, StringBuilder 사용
 * 3. BufferedReader, repeat(i) 반복 사용
 */

public class Main {

    public static void main(String[] args) throws IOException {


        /*
        1번 방법

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i ; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        */

        /*
        2번 방법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        br.close();
        System.out.println(sb);
        */
        
        //3번 방법
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i)).append("\n");
        }
        br.close();
        System.out.println(sb);

        
    }
}
