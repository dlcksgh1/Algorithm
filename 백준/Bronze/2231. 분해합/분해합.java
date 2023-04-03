import java.io.*;

public class Main{
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i = 1; i < n ; i++){
			int k = i;
			int sum = i;
			while(k > 0){
				sum += (k % 10);
				k /= 10 ;
			}
			if(n == sum){
				result = i;
				break;
			}
		 }
		 System.out.println(result);
	}
}