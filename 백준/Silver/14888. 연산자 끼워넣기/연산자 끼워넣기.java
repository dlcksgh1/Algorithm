import java.util.*;
import java.io.*;

public class Main{
	public static int[] num;
	public static int[] operator;
	public static int n, max = -(int)1e9, min = (int)1e9 ;
	
	public static void main(String srgs[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n ;i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <	4; i++){
			operator[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, num[0]);
		System.out.println(max);
		System.out.println(min);
		
	}
	
	public static void dfs(int depth ,int sum){
		if(depth == n-1){
			//System.out.println(sum);
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				
				switch (i){
					case 0: dfs(depth+1 ,sum + num[depth+1]); break;
					case 1: dfs(depth+1 ,sum - num[depth+1]); break;
					case 2: dfs(depth+1 ,sum * num[depth+1]); break;
					case 3: dfs(depth+1 ,sum / num[depth+1]); break;
						
				}
				
				operator[i]++;
			}
		}
	}
}