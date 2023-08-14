
/*
5
55 185
58 183
88 186
60 175
46 155
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person{
	
	private int wigth;
	private int high;
	private int rank;
	
	
	public Person(int wigth, int high) {
		super();
		this.wigth = wigth;
		this.high = high;
	}
	
	
	public int getWigth() {
		return wigth;
	}
	
	public int getHigh() {
		return high;
	}
	
	
	public int getRank() {
		return rank;
	}


	public void changeRank(int rank){
		this.rank = rank;
	}
	
}

public class Main{


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int k = Integer.parseInt(st.nextToken());
		
		ArrayList<Person> list = new ArrayList<>();
		
		for(int i =0 ; i < k ; i ++) {
			st = new StringTokenizer(br.readLine()); 
			int wigth = Integer.parseInt(st.nextToken());
			int high = Integer.parseInt(st.nextToken());			
			list.add(new Person(wigth, high));
			
		}
		
		for(int i = 0 ; i < k ; i ++){
			int rank = 1;
			for(int j = 0 ; j < k ; j ++ ){
				if(i == j) continue;
				if((list.get(i).getWigth() < list.get(j).getWigth()) && (list.get(i).getHigh() < list.get(j).getHigh()) ){
					rank ++;
				}
			}
			list.get(i).changeRank(rank);
		}
		for(int i = 0 ; i < k ; i ++) {
			System.out.print(list.get(i).getRank()+" ");
		}
	}
	
}