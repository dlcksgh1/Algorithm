import java.util.*;
import java.io.*;

class Edge implements Comparable<Edge>{
	private int distance;
	private int node1;
	private int node2;
	
	public Edge(int node1, int node2, int distance){
		this.distance = distance;
		this.node1 = node1;
		this.node2 = node2;
	}
	public int getDistance(){
		return this.distance;
	}
	public int getNode1(){
		return this.node1;
	}
	public int getNode2(){
		return this.node2;
	}
	
	@Override
	public int compareTo(Edge other){
		return this.distance < other.distance ? -1 : 1;
	}
	
}

public class Main{
	
	public static int v;
	public static int e;
	public static int[] parent;
	public static ArrayList<Edge>edge = new ArrayList<>();
	
	public static int findParent(int x){
		if(x == parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
	public static void unionParent(int a, int b){
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	
	public static void main(String args[]) throws IOException{
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			parent = new int[v+1];
			for(int i = 1 ;i <=v; i++){
				parent[i] = i;
			}
			for(int i = 0 ;i < e; i++){
				st = new StringTokenizer(br.readLine());
				edge.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			Collections.sort(edge);
			
			int sum = 0;
			for(int i = 0 ;i < e; i++){
				int node1 = edge.get(i).getNode1();
				int node2 = edge.get(i).getNode2();
				int distance = edge.get(i).getDistance();
				if(findParent(node1) == findParent(node2)) continue;
				unionParent(node1, node2);
				sum += distance;
			}
			System.out.println(sum);
			
	}
}
