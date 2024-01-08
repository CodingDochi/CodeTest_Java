package greedy.Lessons_42860;

import java.util.Arrays;

class Solution {
    int cnt;

    // 상태의 변화 양상
    // 1. 인덱스0 -> 오른쪽
    // 2. 인덱스0 -> 오른쪽 -> 왼쪽 -> 역순
    // 3. 인덱스0 -> 왼쪽(1) -> 역순 -> 역순 거리 -> 오른쪽

    // 상태 변화의 유인
    // 종료 지점 : 연속된 가장 긴 A값들의 인덱스 시작 또는 종료
    // 정 중앙을 기준으로 인덱스 0부터 시작된, 가장 긴 연속적 A 구간 직전까지의 구간을 a,
    // 정 중앙에서 인덱스 0 쪽으로 치우친 가장 긴 A 구간 부분을 b,
    // 정 중앙에서 마지막 인덱스 쪽으로 치우친 가장 긴 A 구간 부분을 c,
    // 그리고 나머지 부분을 d라고 한다.
    // 1번 전략 거리 : a+b+c+d
    // 2번 전략 거리 : 2a+d+1
    // 3번 전략 거리 : 1+2d+a

    private int select_path(String name) {
        char[] character_set = new char[name.length()];

        for (int i = 0; i < name.length(); i++) {
            character_set[i] = name.charAt(i);
        }

        // 가장 긴 연속 A 구간 찾기

        int a_cnt=0;
        int max_a_cnt=0;
        int idx=0;
        for (int i=0; i < character_set.length; i = i+idx) {


            if (idx < character_set.length && character_set[idx]=='A') {
                while (idx < character_set.length && character_set[idx]=='A') {
                    a_cnt++;
                    idx++;
                }
                if (max_a_cnt < a_cnt) {
                    max_a_cnt = a_cnt;
                }
                a_cnt = 0;
            } else {
                idx++;
            }
        }
        int end_idx_f = idx - max_a_cnt;
        int end_idx_b = idx;

        // 구간 분할

        int a_range = end_idx_f; // A가 시작하는 인덱스
        int b_range = character_set.length/2 - end_idx_f; // 전체 길이가 홀수일 경우 더 짧은 쪽에서 A의 길이
        int c_range = end_idx_b - character_set.length/2; // 전체 길이가 홀수일 경우 더 긴 쪽에서 A의 길이
        int d_range = character_set.length - end_idx_b -1; // A가 종료되는 인덱스

        System.out.println("length : "+character_set.length+"   length/2 : "+character_set.length/2+"   a : "+a_range+"   b : "+b_range+"   c : "+c_range+"   d : "+d_range);

        if (a_range == 0 && d_range < 0 && character_set.length == (b_range+c_range)) {
            cnt = 0;
        }


        // 전략 선택
        int strategy1 = a_range + b_range + c_range + d_range - 1;
        int strategy2 = 2 * a_range + d_range + 1;
        int strategy3 = 1 + 2 * d_range + a_range;

        cnt = Math.min(strategy1, Math.min(strategy2, strategy3));


        System.out.println(cnt);
        return cnt;
    }

    private int calc_min_cnt (String name) {
        int start = Character.getNumericValue('A');
        int end = Character.getNumericValue('Z');

        for (int i=0; i<name.length(); i++) {
            int spell = Character.getNumericValue(name.charAt(i));
            int min_dist = Math.min((spell-start), (end-spell+1));
            cnt = cnt + min_dist;
        }

        System.out.println(cnt);
        return cnt;
    }

    public int solution(String name) {
        select_path(name);
        calc_min_cnt(name);
        return cnt;
    }

    public static void main(String[] args) {
        String name = "AAB";
        new Solution().solution(name);
    }
}