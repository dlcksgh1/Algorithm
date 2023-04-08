import java.io.*;
import java.util.*;


class Node{

    private int start;
    private int end;
    private int dist;

    public Node(int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getDist() {
        return dist;
    }
}

public class Main{




    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i ++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());;
            int dist = Integer.parseInt(st.nextToken());

            // 역주행을 해야하거나, 지름길이 아닌경우는 제외
            if(end > d || (end - start) <= dist) continue;
            list.add(new Node(start, end, dist));
        }
        Collections.sort(list, new Comparator<Node>() {

            @Override
            public int compare(Node o1, Node o2) {
                if(o1.getStart() == o2.getStart()) return o1.getEnd() - o2.getEnd();
                return o1.getStart() - o2.getStart();
            }
        });

        int[] dists = new int[d+1];
        Arrays.fill(dists, (int)1e9); // 배열 초기화
        dists[0] = 0;
        int idx = 0, move = 0;
        while (move < d){
            if(idx < list.size()){
                Node node = list.get(idx);
                if(move == list.get(idx).getStart()){
                    dists[node.getEnd()] = Math.min(dists[move] + node.getDist(), dists[node.getEnd()]);
                    idx++;
                }else{
                    dists[move + 1] = Math.min(dists[move + 1], dists[move] + 1);
                    move++;
                }
            } else{
                dists[move + 1] = Math.min(dists[move + 1], dists[move] + 1);
                move++;
            }

        }
        System.out.println(dists[d]);

    }


}