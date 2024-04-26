import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(new Node(Integer.parseInt(br.readLine()), i));
        }
        Collections.sort(list);
        System.out.println(list.get(8).num);
        System.out.println(list.get(8).index);

    }
}


class Node implements Comparable<Node>{
    int num;
    int index;

    public Node(int num, int index) {
        this.num = num;
        this.index = index;
    }


    @Override
    public int compareTo(Node node) {

        if (node.num < num) {
            return 1;
        } else if (node.num > num) {
            return -1;
        }
        return 0;
    }
}
