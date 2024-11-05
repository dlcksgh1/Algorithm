import java.io.*;
import java.util.*;

public class Main {

    
    public static int[] d;
    public static int INF = Integer.MAX_VALUE;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i <= n ; i ++) {
            graph.add(new ArrayList<Node>());
        }
        
        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken()); 
            graph.get(start).add(new Node(end, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        d = new int[n+1];
        Arrays.fill(d, INF);
        dijkstra(start);
        System.out.println(d[end]);
    }
    
    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        d[start] = 0;
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int cost = node.cost;
            if(d[index] < cost) continue;
            for(int i = 0 ; i < graph.get(index).size(); i++) {
                int sum = d[index] + graph.get(index).get(i).cost;
                if(d[graph.get(index).get(i).index] > sum) {
                    d[graph.get(index).get(i).index] = sum;
                    pq.offer(new Node(graph.get(index).get(i).index, sum));
                }
            }
        }
    }
}


class Node implements Comparable<Node> {
    int index;
    int cost;
    
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}