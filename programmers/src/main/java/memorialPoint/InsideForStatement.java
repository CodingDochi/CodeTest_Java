package memorialPoint;


import java.util.*;

public class InsideForStatement {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            Set<String> nameSet = new HashSet<>(Arrays.asList(photo[i]));
            int res = Arrays.stream(name)
                    .filter(nameSet::contains)
                    .mapToInt(j -> yearning[Arrays.asList(name).indexOf(j)])
                    .sum();
            answer[i] = res;
        }

        return answer;
    }
}
