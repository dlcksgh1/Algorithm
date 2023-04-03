import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			String str = br.readLine();
			if(str.equals("END")) break;
			StringBuilder reverse = new StringBuilder();
			reverse.append(str);
			sb.append(reverse.reverse() + "\n");
		}
		System.out.println(sb);
	}
}