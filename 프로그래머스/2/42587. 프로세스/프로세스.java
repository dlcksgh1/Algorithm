import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i , priorities[i]));
        }
        Integer[] newPriorities = Arrays.stream(priorities).boxed().toArray(Integer[]::new);
        Arrays.sort(newPriorities, Collections.reverseOrder());

        boolean match = false;
        for (int i = 0; i < newPriorities.length; i++) {

            while(true) {
                if (queue.peek().priority == newPriorities[i]) {
                    Process compareProcess = queue.poll();
                    if (compareProcess.location == location) {
                        match =true;
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
        return answer;
    }
}

class Process {
    int location;
    int priority;

    public Process(int location, int priority) {
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