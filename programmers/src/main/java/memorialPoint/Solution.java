package memorialPoint;

import java.util.*;

import java.util.*;

class Solution {

    private int find_and_add(List<String> unit, Map<String, Integer> point_per_name) {
        int res = unit.parallelStream().filter(elem -> point_per_name.containsKey(elem)).mapToInt(elem -> point_per_name.get(elem)).sum();

        return res;
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> point_per_name = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            point_per_name.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        int i = 0;

        List<List<String>> container = new ArrayList<List<String>>();
        for (String[] inner : photo) {
            List<String> unit= Arrays.asList(inner);
            answer[i] = (find_and_add(unit, point_per_name));
            i++;
        }

        return answer;
    }
}