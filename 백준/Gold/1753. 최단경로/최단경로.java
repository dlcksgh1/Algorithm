import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라 알고리즘 사용하여 최단경로 구하기
 */
public class Main {

    public static ArrayList<ArrayList<Node5>> graph = new ArrayList<ArrayList<Node5>>();
    public static int[] d;
    public static int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int first = Integer.parseInt(br.readLine());
        d = new int[v + 1];
        Arrays.fill(d, INF);
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node5(end, distance));
        }
        dijkstra(first);
        for (int i = 1; i <= v; i++) {
            System.out.println(d[i] != (int)1e9 ? d[i] : "INF");
        }
    }

    public static void dijkstra(int first) {
        PriorityQueue<Node5> pq = new PriorityQueue<Node5>();
        pq.offer(new Node5(first, 0));
        d[first] = 0;
        while (!pq.isEmpty()) {
            Node5 node = pq.poll();
            int distance = node.distance;
            int index = node.index;
            if(d[index] < distance) continue;

            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = graph.get(index).get(i).distance + distance;
                if (cost < d[graph.get(index).get(i).index]) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.offer(new Node5(graph.get(index).get(i).index, cost));
                }
            }
        }
    }
}

class Node5 implements Comparable<Node5> {

    int index;
    int distance;

    public Node5(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node5 other) {
        if (this.distance > other.distance) {
            return 1;
        } else if (this.distance == other.distance) {
            return 0;
        } else {
            return -1;
        }
    }

}