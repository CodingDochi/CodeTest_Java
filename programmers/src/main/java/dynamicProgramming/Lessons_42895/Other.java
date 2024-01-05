package dynamicProgramming.Lessons_42895;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Other {

    // 순서쌍 a에 b 합치기
    public void union_set(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for (int n1: a) {
            for (int n2: b) {
                union.add(n1 + n2);
                union.add(n1 - n2);
                union.add(n1 * n2);
                if (n2 != 0) {
                    union.add(n1 / n2);
                }
            }
        }
    }
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();

        for (int i=0; i<9; i++) {
            setList.add(new HashSet<>()); // N 사용횟수의 개수별 해쉬 셋
        }
        setList.get(1).add(N); // N부터 시작
        if (number == N) {
            return 1;
        }
        for (int i=2; i<9; i++) {
            for (int j=1; j<=i/2; j++) {
                union_set(setList.get(i), setList.get(i-j), setList.get(j));
                union_set(setList.get(i), setList.get(j), setList.get(i-j));
            }
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));
            for (int num : setList.get(i)) {
                if (num == number) {
                    return i;
                }
            }
        }
        return -1;
    }

}
