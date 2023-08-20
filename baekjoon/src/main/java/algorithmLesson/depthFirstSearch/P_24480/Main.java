package algorithmLesson.depthFirstSearch.P_24480;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int N;
    int M;
    int R;
    int cnt = 0;

    List<Integer> visited_order;

    private void dfs(List<Boolean> visited, List<List<Integer>> E, int R) {

        visited.set(R, true);
        visited_order.set(R, ++cnt);
        for (int elem : E.get(R)) {
            if (!visited.get(elem)) {
                dfs(visited, E, elem);
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        List<List<Integer>> E = new ArrayList<>();

        for (int i = 1; i <= N+1; i++) {
            E.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            E.get(u).add(v);
            E.get(v).add(u);
        }

        for (List<Integer> list : E) {
            Collections.sort(list, Comparator.reverseOrder());
        }

        List<Boolean> visited = new ArrayList<>();
        for (int v = 0; v <= N+1; v++) {
            visited.add(false);
        }

        visited_order = new ArrayList<>();
        for (int v = 0; v<=N+1; v++) {
            visited_order.add(0);
        }

        dfs(visited, E, R);

        StringBuilder sb = new StringBuilder();
        for (int v = 1; v <N+1; v++) {
            sb.append(visited_order.get(v)).append("\n");
        }

        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}