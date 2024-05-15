import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int classes = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] students = new int[classes];
		for(int i = 0 ; i < classes; i++) {
			students[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int dir = Integer.parseInt(st.nextToken());;
		int sub = Integer.parseInt(st.nextToken());;
		long count =0;
		for(int i = 0 ; i < classes; i++) {
			count++;
			students[i] -= dir;
			if(students[i] <= 0) continue;
			int cnt = 0;
			if(students[i] % sub > 0) {
				cnt = students[i] / sub +1; 
			}else if(students[i] > 0){
				cnt = students[i] / sub;
			}
			count += cnt;
		}
		System.out.println(count);
	}

}