package dynamicProgramming.P_10164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int N, M, K;
    int[][] map, cache;
    int[] dx = {0, 1};
    int[] dy = {1, 0};
    Node stopover;

    static class Node {
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int dfs(Node cur, Node dst) {
    if (cur.row == dst.row && cur.col == dst.col) {
        return 1;
    } for (int i =0; i < 2; i++) {
            Node next = new Node(cur.row + dy[i], cur.col + dx[i]);

//            System.out.println("inside dfs : next.row "+next.row);
//            System.out.println("inside dfs : next.col "+next.col);

            if (!isValidRange(next, dst)) {
//                System.out.println("isValidRange : "+isValidRange(next, dst));
                continue;
            }
            if (cache[next.row][next.col] != 0) {

//                System.out.println("inside cache : next.row "+next.row);
//                System.out.println("inside cache : next.col "+next.col);
//                System.out.println("inside cache next : "+cache[next.row][next.col]);

                cache[cur.row][cur.col] += cache[next.row][next.col];
            } else {
//                System.out.println("inside cache : cur.row "+cur.row);
//                System.out.println("inside cache : cur.col "+cur.col);
//                System.out.println("inside cache next : "+cache[cur.row][cur.col]);
                cache[cur.row][cur.col] += dfs(next, dst);

            }
        }
        return cache[cur.row][cur.col];
    }

    private boolean isValidRange(Node appoint, Node dst) {
        if (1 <= appoint.row && appoint.row <= dst.row && 1 <= appoint.col && appoint.col <= dst.col) {
            return true;
        } else {
            return false;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cache = new int[N+1][M+1];
        map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = (i-1) * M + j;
                if (map[i][j] == K) {
                    stopover = new Node(i, j);
                }
            }
//            System.out.println(Arrays.toString(map[i]));
        }

//        System.out.println(stopover.row);
//        System.out.println(stopover.col);

        int paths = 0;
        if (K==0) {
            paths = dfs(new Node(1, 1), new Node(N, M));
        } else {
            paths = dfs(new Node(1, 1), stopover) * dfs(stopover, new Node(N, M));
        }

        System.out.println(paths);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
