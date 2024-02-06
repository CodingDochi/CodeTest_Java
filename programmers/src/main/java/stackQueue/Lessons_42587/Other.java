package stackQueue.Lessons_42587;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Other {

    public int solution(int[] priorities, int location) {

        int answer = 0;
        int size = priorities.length - 1;

        Queue<Integer> q = new LinkedList<>();
        for (int priority : priorities) {
            q.add(priority);
        }

        Arrays.sort(priorities);

        while(!q.isEmpty()) {
            Integer priority = q.poll();
            if(priority == priorities[size - answer]) {
                answer++;
                location--;
                if (location < 0) {
                    break;
                }
            } else {
                q.add(priority);
                location--;
                if (location < 0) {
                    location = q.size()-1;
                }
            }
        }
        return answer;
    }
}
