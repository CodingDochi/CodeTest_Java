package arrays_differ;

import java.util.ArrayList;
import java.util.List;

public class Kata {

    /*
    Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
    new int[] {5}, Kata.arrayDiff(new int [] {3,4,5}, new int[] {1,2,3,4})
     */
    public static int[] arrayDiff(int[] a, int[] b) {

        if (b.length == 0) {
            return a;
        }
        if (a.length == 0) {
            return a;
        }

        List<Integer> same_elem = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    same_elem.add(b[j]);
                }
            }
        }

        List<Integer> a_list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            a_list.add(a[i]);
        }

        a_list.removeAll(same_elem);
        int[] answerArray = new int[a_list.size()];
        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = a_list.get(i);
        }

        return answerArray;
    }

}