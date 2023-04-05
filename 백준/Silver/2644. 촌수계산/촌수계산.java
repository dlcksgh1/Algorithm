//촌수계산 문제는 문제를 자세히 생각해보면
//가중치가 1인 그래프의 최단경로를 구하는 문제와 같다.
//촌수란 연결되어있다고 볼 수 있기 때문이다.

//최단경로 문제는 가중치가 없는 그래프에서는 보통 두 정점을 잇는 가장 적은 간선의 개수를 뜻하고,
//가중치가 존재하는 그래프에서는 두 정점을 잇는 간선들의 가중치의 합 중 최소 가중치 합을 의미한다.
//가중치가 0, 1 일 경우에는 bfs, 가중치가 여러개일 경우는 다익스트라를 사용한다.

import java.io.*;
import java.util.*;

public class Main{

	static ArrayList<ArrayList<Integer>> edges; // 간선을 저장
	static int[] min; // 최단거리 저장 배열

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		min = new int[n+1];
		Arrays.fill(min, -1); // 거리를 초기화
		edges = new ArrayList<ArrayList<Integer>>();
		for(int i = 0 ; i <= n ; i++){
			edges.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < k ; i ++){ // 간선을 양방향으로 추가
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			edges.get(x).add(y);
			edges.get(y).add(x);
		}
		min[start] = 0;
		bfs(start, end);
		System.out.println(min[end]);
	}
	
	static void bfs(int start, int end){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()){
			int k = queue.poll();
			
			if(k == end) break; // end 값에대한 최소 값이 필요한 것이기 때문에 end 값이 들어가있으면 작업을 끝낸다.
			
			for(int i = 0 ; i < edges.get(k).size(); i++){
			
				if(min[edges.get(k).get(i)] == -1){ //-1 이외의 값이 들어가 있다면 이미 최소 값이기 때문에 min 에 넣지 않는다.
					min[edges.get(k).get(i)] = min[k] +1;
					queue.offer(edges.get(k).get(i));
				}
			}
		}
	}
}