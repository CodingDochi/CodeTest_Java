package backtracking.P_15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Other {

    int N;
    int M;

    StringBuilder sb = new StringBuilder();
    List<Boolean> visited;
    List<Integer> candidate;
    List<Integer> sequence;

    private void rec(int depth, int input) {
        if (depth==M) {
            for (int elem : sequence) {
                sb.append(elem).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=0; i<N; i++) {
            int visit = candidate.get(i);
            if (input == visit) {
                continue;
            }
            if (!visited.get(visit)) {
                visited.set(visit, true);
                sequence.add(visit);
                rec(depth + 1, visit);
                sequence.remove(sequence.size() - 1);
                visited.set(visit, false);
            }
        }

    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        candidate = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            candidate.add(i);
        }
        sequence = new ArrayList<>();

        visited = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            visited.add(false);
        }

        rec(0, 0);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Other().solution();
    }

}

