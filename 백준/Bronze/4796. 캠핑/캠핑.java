import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer>list = new ArrayList<>();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int count  = 0;
			int remainder = 0;
			int sum = 0;
			if(l == 0 && p == 0 && v == 0) {
				break;
			}
			count = v / p;
			remainder = v % p;
			if(remainder < l) {
				sum = l * count + remainder;
			}else {
				sum = l * (count + 1);
			}
			list.add(sum);
		}
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println("Case "+ (i+1) + ": "+list.get(i));
		}
	}

}
