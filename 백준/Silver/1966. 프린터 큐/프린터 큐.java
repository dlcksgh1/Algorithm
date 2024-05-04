import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int testCase = 0;
        while(testCase < k){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            int answer = 0;
            ArrayList<Integer> newPriorities = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                newPriorities.add(Integer.parseInt(st.nextToken()));
            }

            Queue<Print> queue = new LinkedList<>();
            for (int i = 0; i < newPriorities.size(); i++) {
                queue.offer(new Print(i, newPriorities.get(i)));
            }
            Collections.sort(newPriorities, Collections.reverseOrder());

            boolean match = false;
            for (int i = 0; i < newPriorities.size(); i++) {

                while (true) {
                    if (queue.peek().priority == newPriorities.get(i)) {
                        Print comparePrint = queue.poll();
                        if (comparePrint.location == location) {
                            match = true;
                        }
                        break;
                    } else {
                        queue.offer(queue.poll());
                    }
                }
                if (match) {
                    answer = i + 1;
                    break;
                }
            }
            System.out.println(answer);

            testCase++;
        }
    }
}

class Print {
    int location;
    int priority;

    public Print(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}