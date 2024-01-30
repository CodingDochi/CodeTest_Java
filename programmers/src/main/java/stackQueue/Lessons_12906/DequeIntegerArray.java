package stackQueue.Lessons_12906;

import java.util.Deque;
import java.util.LinkedList;

public class DequeIntegerArray {
    public Integer[] solution(int[] arr) {
        Deque<Integer> int_deque = new LinkedList<>();
        int_deque.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (int_deque.peekLast() != arr[i]) {
                int_deque.add(arr[i]);
            }
        }
        Integer[] int_arr = int_deque.toArray(new Integer[0]);
        // int[] int_arr = int_deque.stream().mapToInt(Integer::intValue).toArray();

        return int_arr;
    }
}
