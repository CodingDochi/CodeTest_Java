package stackQueue.Lessons_42586;

import java.util.*;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> done = new LinkedList<>();
        Stack<Integer> task = new Stack<>();

        for(int i=0; i < progresses.length; i++) {
            int day_cnt = 0;
            while (progresses[i] < 100) {
                progresses[i] = progresses[i] + speeds[i];
                day_cnt++;
//                System.out.println("progress : " + progresses[i] + "   speed : " + speeds[i] + "   days : " + day_cnt);
            }
//            done.add(day_cnt);
//            System.out.println("done : "+done.toString());
        }
        int task_cnt = 1;
        task.push(task_cnt);
        int std = done.poll();
        while (!done.isEmpty()){
            int next = done.poll();
            if (std < next) {
                task_cnt = 1;
                task.push(task_cnt);
                std = next;
            } else {
                task_cnt++;
                task.pop();
                task.push(task_cnt);
            }
//            System.out.println("std : "+std+"   done.peek() : "+done.peek()+"   task.cnt : "+task_cnt);

        }
        Integer[] arr = task.toArray(new Integer[0]);
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        int[] processes = {1, 95, 95};
        int[] speeds = {99, 1, 1};

        new Solution().solution(processes, speeds);
    }

}