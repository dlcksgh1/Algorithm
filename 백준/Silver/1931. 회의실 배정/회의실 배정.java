import java.io.*;
import java.util.*;

class Meeting implements Comparable<Meeting>{
	private int st;
	private int end;
	public void setSt(int st){
		this.st = st;
	}
	public int getSt(){
		return this.st;
	}
	public void setEnd(int end){
		this.end = end;
	}
	public int getEnd(){
		return this.end;
	}	
	public Meeting(int st, int end){
		this.st = st;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting other){
		if(this.end == other.end) {
			return this.st >= other.st ? 1 : -1;
		}
		return this.end >= other.end ? 1 : -1;
	}
}

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Meeting>list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++){
			st = new StringTokenizer(br.readLine()); 
			list.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		int count = 1;
		int end = list.get(0).getEnd();
		for(int i = 1; i < n ; i++){
			int start = list.get(i).getSt();
			if(start >= end){
				count++;
				end = list.get(i).getEnd();
			}
		}
		System.out.println(count);
	}
}