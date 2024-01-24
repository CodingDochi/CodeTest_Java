package practiceTest.fruitSeller;

import java.util.*;


class Solution {
    public int solution(int k, int m, int[] score) {

        List<Integer> apples = new ArrayList<>();
        for (Integer elem : score) {
            apples.add(elem);
        }

        if (apples.size() < m) {
            return 0;
        }

        apples.sort(Comparator.reverseOrder());
        int dump = apples.size() % m;
        apples.subList(apples.size()-dump, apples.size()).clear();

        int sum = 0;
        for (int i = 0; i < apples.size(); i=i+m) {
            List<Integer> unit = apples.subList(i, i+m);
            Optional<Integer> min_p = unit.stream().reduce(Integer::min);

            sum = sum + (min_p.get() * m);
        }

        return sum;
    }
}