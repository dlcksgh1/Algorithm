/*

Comparable과 Comparator는 모두 인터페이스 이기 때문에
Comparable 혹은 Comparator을 사용하고자 한다면 인터페이스 내에 선언된 메소드를 '반드시 구현'해야한다.

Comparable은 compareTo ,Comparator는 compare 메서드를 구현 해야한다.
두 인터페이스는 객체를 정렬을 하기 위해 객체를 비교할 수 있도록 만들어 주는 것이다.

Comparable은 "자기 자신과 매개변수 객체를 비교"하는 것이고, Comparator는 "두 매개변수 객체를 비교"한다는 것이다.


쉽게 말하자면, Comparable은 자기 자신과 파라미터로 들어오는 객체를 비교하는 것이고, Comparator는 자기 자신의 상태가 어떻던 상관없이 파라미터로 들어오는 두 객체를 비교하는 것이다. 즉, 본질적으로 비교한다는 것 자체는 같지만, 비교 대상이 다르다는 것이다.


또 다른 차이점이라면 Comparable은 lang패키지에 있기 때문에 import 를 해줄 필요가 없지만, Comparator는 util패키지에 있다.

*/


import java.io.*;
import java.util.*;

class Node1{
	
	private int x;
	private int y;
	
	public Node1(int x ,int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	
}

class Node2 implements Comparable<Node2>{
	
	private int x;
	private int y;
	
	public Node2(int x ,int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	public void setY(int y){
		this.y = y;
	}
	
	@Override
	public int compareTo(Node2 node){
		return getX() - node.getX();
	}
}

public class Main{

	public static void main(String[] args) throws IOException{
		ArrayList<Node1> list1 = new ArrayList<>();
		ArrayList<Node2> list2= new ArrayList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int y = 1;
		while(st.hasMoreTokens()){
			int x = Integer.parseInt(st.nextToken());
			list1.add(new Node1(x ,y));
			list2.add(new Node2(x ,y));
			y++;
		}
		
		Collections.sort(list1, new Comparator<Node1>(){
			@Override
			public int compare(Node1 node1, Node1 node2){
				return node1.getX() - node2.getX();
			}
		});
		Collections.sort(list2);
		
		
		for(int i = 0 ; i < list1.size(); i++){
			System.out.print(list1.get(i).getX()+" ");
		}
		System.out.println();
		for(int i = 0 ; i < list2.size(); i++){
			System.out.print(list2.get(i).getX()+" ");
		}
	}

}
