
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[k+1][21];
		int[] result = new int[k+1];
		int cnt = 1;
		while(cnt < k){
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			cnt = Integer.parseInt(st.nextToken());
			for(int i = 1 ; i <=20 ; i++){
				arr[cnt][i] = Integer.parseInt(st.nextToken());
				int target = i;
				for(int j = (i-1); j >= 1; j--){
					if(arr[cnt][target] < arr[cnt][j]){
						sum++;
						int temp = arr[cnt][target];
						arr[cnt][target] = arr[cnt][j];
						arr[cnt][j] = temp;
						target = j;
					}else{
						break;
					}
				}
			}
			result[cnt] = sum;
		}
		for(int i = 1 ; i <= k; i++){
			System.out.println(i +" "+result[i]);
		}
		
	}
	
}