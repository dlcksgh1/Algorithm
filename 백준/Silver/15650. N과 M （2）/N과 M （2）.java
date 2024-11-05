import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> result;
    static int[] str;
    static boolean[] visited;   
    static int cnt, n;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        cnt = Integer.parseInt(st.nextToken());
        str = new int[cnt];
        visited = new boolean[n];
        dfs(0, 0);
        System.out.println(sb.toString());
    }
    
    public static void dfs(int depth, int start) {
        if(depth == cnt) {
            for(int val : str) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = start ; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                str[depth] = i+1; 
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}