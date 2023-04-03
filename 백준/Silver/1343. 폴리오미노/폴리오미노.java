import java.io.*;

public class Main{
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] substr = str.split("\\.", -1);
		String result = "";
		for(int i = 0 ; i < substr.length; i++){
			if(substr[i].length() % 2 == 1) {
				result="-1";
				break;
			}
			int countA = substr[i].length()/4;
			int countB = (substr[i].length()%4)/2;
			for(int j = 0 ; j < countA; j++){
				result += "AAAA";
			}
			for(int j = 0 ; j < countB; j++){
				result += "BB";
			}
			if(i != (substr.length -1))result += ".";
			
		}
		System.out.println(result);
	}
}