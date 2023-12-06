package duplicate_encoder;

import java.util.Arrays;


public class DuplicateEncoder {
    static String encode(String word){
        String word_copy = word.toLowerCase();

        String[] answer = new String[word.length()];
        Arrays.fill(answer, "");
        for (int i = 0; i < word_copy.length(); i++) {
            if (answer[i].equals("")) {
                answer[i] = "(";
                for (int j = word_copy.length()-1; j >= i+1; j--) {
                    if (word_copy.charAt(i) == word_copy.charAt(j)) {
                        answer[i] = ")";
                        answer[j] = ")";
                    }
                    if (answer[i] != ")" && (word_copy.charAt(i) != word_copy.charAt(j))){
                        answer[i] = "(";
                    }
                }
            }
        }
        String res = String.join("", answer);

        return res;
    }
}
