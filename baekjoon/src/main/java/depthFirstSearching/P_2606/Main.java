package depthFirstSearching.P_2606;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    List<Integer> visited = new ArrayList<>();
    private void calc(List<List<Integer>> network, Integer cur) {
        if (!visited.contains(cur)) {
            visited.add(cur);
            for (int next : network.get(cur)) {
                calc(network, next);
            }
        } else {
            return;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Integer>> network = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            network.add(new ArrayList<>(0));
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            network.get(num1).add(num2);
            network.get(num2).add(num1);
        }
//        for (int i = 0; i < N+1; i++) {
//            System.out.println(network.get(i).toString());
//        }
        Integer cur = 1;
        calc(network, cur);
//        System.out.println(visited.toString());
        System.out.println(visited.size() -1);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
