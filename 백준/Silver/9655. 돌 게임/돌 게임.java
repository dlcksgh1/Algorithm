import java.io.*;

public class Main{


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = bottemUp(n);
        if(result % 2 == 0){
            System.out.println("CY");
        }else{
            System.out.println("SK");
        }
    }


    private static int bottemUp(int n){
        int[] count = new int[n+1];
        if(n < 2 ) return n;
        count[1] = 1;
        count[2] = 2;
        for(int i = 3; i <= n ; i ++){
            count[i] = Math.min(count[i-3], count[i-1]) + 1;

        }
        return count[n];

    }
}