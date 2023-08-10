
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{

    private int gold;
    private int silver;
    private int bronze;
    private int rank;
    private int num;



    public Node(int gold, int silver, int bronze, int num) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.num = num;
    }

    @Override
    public int compareTo(Node o){

        if(this.getGold() == o.getGold()){

            if(this.getSilver() == o.getSilver()){
                return o.getBronze() - this.getBronze();
            }
            return o.getSilver() - this.getSilver();
        }

        return o.getGold() - this.getGold();
    }

    public int getGold() {
        return gold;
    }

    public int getSilver() {
        return silver;
    }

    public int getBronze() {
        return bronze;
    }

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getNum() {
        return num;
    }



}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            Node node = new Node(gold, silver, bronze, num);
            list.add(node);

        }
        Collections.sort(list);

        int rank = 1;
        list.get(0).setRank(rank);

        for(int i = 1; i < cnt ; i++){
            int gold1 = list.get(i-1).getGold();
            int gold2 = list.get(i).getGold();
            int silver1 = list.get(i-1).getSilver();
            int silver2 = list.get(i).getSilver();
            int bronze1 = list.get(i-1).getBronze();
            int bronze2 = list.get(i).getBronze();
            rank++;
            if((gold1 == gold2) && (silver1 == silver2) &&(bronze1 == bronze2)){
                list.get(i).setRank(list.get(i-1).getRank());
            }else{
                list.get(i).setRank(rank);
            }
            if(list.get(i).getNum() == target){
                System.out.println(list.get(i).getRank());
                break;
            }
        }
    }
}