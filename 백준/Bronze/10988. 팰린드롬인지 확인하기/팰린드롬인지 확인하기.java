import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int start = 0;
        int end = str.length() - 1;
        int result = 1;
        while(start <=end){
            if(str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            }else{
                result=0;
                break;
            }
        }
        System.out.println(result);

    }
}
