package two_to_one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoToOne {

    public static String longest (String s1, String s2) {
        // your code
        char[] char_s1 = s1.toCharArray();
        char[] char_s2 = s2.toCharArray();
        List<Character> char_list = new ArrayList<>();
        for (int i = 0; i < char_s1.length; i++) {
            char_list.add(char_s1[i]);
        }
        for (int i = 0; i < char_s2.length; i++) {
            char_list.add(char_s2[i]);
        }
        Collections.sort(char_list);
        List<Character> answer_list = new ArrayList<>();
        answer_list.add(char_list.get(0));
        for (int i = 1; i < char_list.size(); i++) {
            if (char_list.get(i-1) != char_list.get(i)) {
                answer_list.add(char_list.get(i));
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < answer_list.size(); i++) {
            answer.append(answer_list.get(i));
        }
        return answer.toString();
    }

}