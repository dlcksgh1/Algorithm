import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단거리 구하기  다익스트라 알고리즘 사용
 */

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Node4>> graph = new ArrayList<ArrayList<Node4>>();
    static int[] d;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        Arrays.fill(d, INF);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node4>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(index).add(new Node4(target, distance));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(d[end]);

    }

    static public void dijkstra(int start) {
        PriorityQueue<Node4> pq = new PriorityQueue<>();
        pq.offer(new Node4(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Node4 node = pq.poll();
            int index = node.index;
            int distance = node.distance;
            if(d[index] < distance) continue;
            for (int i = 0; i < graph.get(index).size(); i++) {
                int cost = d[index] + graph.get(index).get(i).distance;
                if (d[graph.get(index).get(i).index] > cost) {
                    d[graph.get(index).get(i).index] = cost;
                    pq.offer(new Node4(graph.get(index).get(i).index, cost));
                }
            }
        }
    }

}

class Node4 implements Comparable<Node4> {
    public int index;
    public int distance;

    public Node4(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node4 other) {

        if (this.distance > other.distance) {
            return 1;
        } else if (this.distance == other.distance) {
            return 0;
        } else {
            return -1;
        }
    }
}
