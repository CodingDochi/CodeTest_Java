package backtracking.P_15650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름 차순이어야 함.
// alphanumeric order

    int N;
    int M;
    List<Integer> base;
    StringBuilder sb = new StringBuilder();

    private void dfs(int cur, int depth) {

        if (depth == M) {
            for (int val : base) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = cur; i <= N; i++) {
            base.add(i);
            dfs(i+1, depth+1);
            base.remove(base.size()-1);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        base = new ArrayList<>();

        dfs(1, 0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
