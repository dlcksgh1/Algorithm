import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] count = new int[91];
		
		int length = str.length();
		for(int i = 0 ; i < length; i ++){
			
			int k = (int)str.charAt(i);
			k = k >= 97 ? (k - 32)  : k;
			count[k] += 1;
			
		}
		int max = 0;
		int index = 0;
		
		for(int i = 65 ; i <=90; i ++){
			//max = Math.max(max, count[i]);
			if(max < count[i]){
				max = count[i];
				index = i;
			}
		}
		
		Arrays.sort(count);
		if(count[89] == count[90]){
			System.out.println("?");
		}else{
			System.out.println((char)(index));
		}
		
		
	}
}