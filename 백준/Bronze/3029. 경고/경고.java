import java.io.*;
public class Main{
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String[] t1 = str1.split(":");
		String[] t2 = str2.split(":");
		int hh = Integer.parseInt(t2[0]) - Integer.parseInt(t1[0]);
		int mm = Integer.parseInt(t2[1]) - Integer.parseInt(t1[1]);
		int ss = Integer.parseInt(t2[2]) - Integer.parseInt(t1[2]);

		if(ss < 0 ){
			ss += 60;
			mm--;
		}
		if(mm < 0 ){
			mm += 60;
			hh--;
		}
		if(hh < 0 ){
			hh += 24;
		}
		
		if(hh==0 && mm ==0 && ss==0) System.out.println("24:00:00");
		else System.out.format("%02d:%02d:%02d",hh,mm,ss );
		
	}
}