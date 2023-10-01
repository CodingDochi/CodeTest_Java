package backtracking.P_15651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //1부터 N까지 자연수 중에서 M개를 고른 수열
    //같은 수를 여러 번 골라도 된다. (중복되는 수열은 안됨)
    //alphanumeric order
    int N;
    int M;
    StringBuilder sb = new StringBuilder();
    List<Integer> sequence;


    private void from_back(int depth) {
        if(depth == M) {
            for (int elem : sequence) {
                sb.append(elem).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (sequence.size() <M) {
                sequence.add(i+1);
                from_back(depth + 1);
                sequence.remove(sequence.size()-1);
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new LinkedList<>();

        from_back(0);
        System.out.println(sb);

    }
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }
}
