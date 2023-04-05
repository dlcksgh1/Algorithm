// 배열정렬 후 이진탐색 사용하여 풀기 
// 완전탐색을 할 경우 시간초과 발생 이진탐색 활용문제라고 볼 수 있다.


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int n, money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        money = Integer.parseInt(br.readLine());
        int result = binarySearch(0, money, sum);
        System.out.println(result);
    }

    private static int binarySearch(int start, int end, int sum){

        if(sum <= end) return arr[n-1];

        while(start <= end){
            int current = 0;
            int mid =  (start + end) / 2;
            for(int i = 0 ; i < n ; i ++){
                if(mid > arr[i]) current += arr[i];
                else current += mid;
            }
            if(current > money) end = mid -1;
            else if(current < money) start = mid +1;
            else return mid;

        }
        return end;
    }
}