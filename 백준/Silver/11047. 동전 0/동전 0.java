import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer>coins = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			coins.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(coins, Collections.reverseOrder());
		int count = 0;
		for(int i = 0 ; i < n ; i++) {
			count += k / coins.get(i);
			k %= coins.get(i);
		}
		System.out.println(count);
	}

}