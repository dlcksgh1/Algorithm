import java.io.*;
import java.util.*;

class Score implements Comparable<Score>{
	private int sc1;
	private int sc2;
	public int getSc1() {
		return sc1;
	}
	public int getSc2() {
		return sc2;
	}
	public Score(int sc1, int sc2){
		this.sc1 = sc1;
		this.sc2 = sc2;
	}
	
	@Override
	public int compareTo(Score other){
		return this.sc1 > other.sc1 ? 1  : -1;
	}
}
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int recycle = Integer.parseInt(br.readLine());
		int cnt = 0;
		int[] result = new int[recycle];
		while(cnt < recycle) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Score>list = new ArrayList<>();
			for(int i = 0 ; i < n ; i ++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list);
			int min = list.get(0).getSc2();
			int count = 1;
			for(int i = 1 ; i < n ; i++ ) {
				if(min > list.get(i).getSc2()) {
					count++;
					min = list.get(i).getSc2();
				}
			}
			result[cnt] = count;
			cnt++;
		}
		for(int i = 0 ; i < recycle; i++) {
			System.out.println(result[i]);
		}
	}

}