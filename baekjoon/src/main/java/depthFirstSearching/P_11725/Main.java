package depthFirstSearching.P_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    int N;
    List<Integer>[] tree;
    int[] parents;
    List<Integer> candidates;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new List[N+1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        parents = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            tree[p].add(c);
            tree[c].add(p);
        }

        for (int i = 1; i <= N; i++) {
            System.out.print("i "+i+" : ");
            for (int j = 0; j < tree[i].size(); j++) {
                System.out.print(+tree[i].get(j) + " ");
            }
            System.out.println();
        }

        parents[1] = 1;
        int[] answer = Arrays.copyOfRange(findParent(tree), 2, N+1);

        for (int parent : answer) {
            System.out.println(parent);
        }

    }

    private int[] findParent(List[] tree) {
        for (int i = 1; i <= N; i++) {
            for (int j=0; j < tree[i].size(); j++) {
                int val = (Integer) tree[i].get(j);
                if (val != 1 && parents[val] == 0) {
                    candidates.add(val);
                }else if (parents[val] != 0 && parents[i] == 0) {
                    parents[i] = val;
                }
            }
            if (candidates.size()>=2) {

            }
        }
        return parents;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
