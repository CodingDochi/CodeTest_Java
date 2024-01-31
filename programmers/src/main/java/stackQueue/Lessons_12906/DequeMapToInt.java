package stackQueue.Lessons_12906;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DequeMapToInt {

    private int[] solution(int[] arr) {
        Deque<Integer> int_deque = new LinkedList<>();
        int_deque.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (int_deque.peekLast() != arr[i]) {
                int_deque.add(arr[i]);
            }
        }
        int[] int_arr = int_deque.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(int_arr));
        return int_arr;
    }

    public static void main(String[] args) {
        int[] arr = {4,4,4,3,3};
        new DequeMapToInt().solution(arr);
    }

}
