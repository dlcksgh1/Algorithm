import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n ; i++ ){
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int max = arr[0];
		for(int i = 1; i < n ; i++){
			max = Math.max(max, arr[i]*(i+1));
		}
		System.out.println(max);
	}
}