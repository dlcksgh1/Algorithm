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
        dfs(0);
        System.out.println(sb.toString());
    }
    
    public static void dfs(int depth) {
        if(depth == cnt) {
            for(int i = 0 ; i < cnt; i ++) {
                sb.append(str[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                str[depth] = i+1; 
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
