import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture>{
	private int si;
	private int ti;
	public void setSi(int si){
		this.si = si;
	}
	public int getSi(){
		return this.si;
	}
	public void setTi(int ti){
		this.ti = ti;
	}
	public int getTi(){
		return this.ti;
	}	
	public Lecture(int si, int ti){
		this.si = si;
		this.ti = ti;
	}
	@Override
	public int compareTo(Lecture other){
		if(this.si == other.si){
			return this.ti >= other.ti ? 1: -1;
		}
		return this.si >= other.si ? 1: -1;
	}
}

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Lecture>lectures = new ArrayList<>();
		for(int i = 0 ; i < n  ;i++){
			st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int ti = Integer.parseInt(st.nextToken());
			lectures.add(new Lecture(si, ti));
		}
		Collections.sort(lectures);
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		for(Lecture lec : lectures){
			int ti = lec.getTi();
			if(!pq.isEmpty() && pq.peek() <= lec.getSi()){
				pq.poll();
			}
			pq.add(ti);
		}
		System.out.println(pq.size());
	}
}