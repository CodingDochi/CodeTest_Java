package hash.Lessons_42578;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, List<String>> closet = new HashMap<>();

        // 옷을 종류별로 맵에 추가
        for (int i = 0; i < clothes.length; i++) {
            closet.putIfAbsent(clothes[i][1], new ArrayList<>());
            closet.get(clothes[i][1]).add(clothes[i][0]);
        }

        int answer = 1;  // 각 종류별 조합의 곱셈을 위한 초기 값

        // 각 종류별로 입지 않는 경우를 고려해 (리스트 크기 + 1)을 곱해준다.
        for (String key : closet.keySet()) {
            answer *= (closet.get(key).size() + 1);
        }

        // 모든 종류에서 하나도 입지 않는 경우를 제외하기 위해 1을 빼준다.
        return answer - 1;
    }
}