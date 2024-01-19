package memorialPoint;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BoxStreamUseCollectors {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> point_per_name = IntStream.range(0, name.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));

        int[] answer = Arrays.stream(photo)
                .mapToInt(inner -> Arrays.stream(inner)
                        .filter(point_per_name::containsKey)
                        .mapToInt(point_per_name::get)
                        .sum())
                .toArray();

        return answer;
    }
}
