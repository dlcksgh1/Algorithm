import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 회의실 배정
 * 시작 끝나는 시간이있고 회의실은 한개임
 * 이게 최대로 사용할 수 있는 개수를 찾아야함
 * 시작시간 종료시간을 입력받고 종료시간을
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] -o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int lastEndTime = 0;

        // 회의 배정
        for (int[] meeting : meetings) {
            if (meeting[0] >= lastEndTime) {
                count++;
                lastEndTime = meeting[1];
            }
        }

        System.out.println(count);
    }
}