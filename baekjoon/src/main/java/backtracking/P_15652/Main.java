package backtracking.P_15652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 1부터 N까지 자연수 중에서 M개를 고른 수열
    // 같은 수를 여러 번 골라도 된다. (중복되는 수열은 안됨)
    // 고른 수열은 비내림차순이어야 한다.
    int N;
    int M;
    StringBuilder sb = new StringBuilder();
    List<Integer> sequence;


    private void rec(int depth) {
        if (depth == M) {
            for (int elem : sequence) {
                sb.append(elem).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (sequence.isEmpty()) {
                sequence.add(i + 1);
                rec(depth + 1);
                sequence.remove(sequence.size() - 1);
            } else if (sequence.get(sequence.size()-1) <= i+1){
                sequence.add(i + 1);
                rec(depth + 1);
                sequence.remove(sequence.size() - 1);
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new LinkedList<>();

        rec(0);
        System.out.println(sb);

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
