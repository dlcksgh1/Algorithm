import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[101];
        int[] score = new int[4];

        int min = 100, max = 0, sum = 0;

        for(int i = 1 ; i <= 3; i ++){
            score[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0 ; i < 3 ; i ++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            min = Math.min(min, start); //가장 빨리 시작하는 시간
            max = Math.max(max, end); //가장 늦게 끝나는 시간
            for(int j = start; j < end; j++){
                arr[j] += 1;
            }
        }
        
        for(int i = min; i < max; i++){
            switch(arr[i]){
                case 1:
                    sum += score[1]*arr[i];
                    break;
                case 2:
                    sum += score[2]*arr[i];
                    break;
                case 3:
                    sum += score[3]*arr[i];
                    break;
            }
        }

        System.out.println(sum);
    }
}
