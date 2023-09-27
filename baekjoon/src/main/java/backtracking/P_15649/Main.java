package backtracking.P_15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// alphanumeric order

public class Main {

    int N;
    int M;
    int [] rest;
    boolean [] visited;
    StringBuilder sb = new StringBuilder();

    private void dfs(int depth) {
        if (depth == M) {
            for (int val : rest) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                rest[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rest = new int[M];
        visited = new boolean[N];

        dfs(0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

