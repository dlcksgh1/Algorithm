
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0 ; i < n ; i ++){
			int x = Integer.parseInt(st.nextToken());
			arr[i] = x;
		}
		
		int count = 0;
		
		for(int start = 0 ; start < n ; start++){
			for(int end = start+1; end < n ; end ++){
				int sum = arr[start];
				sum += arr[end];
				if(target == sum) count++;
			}
		}
		
		System.out.println(count);
		
	}
}
