package depthFirstSearching.P_2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int total, start, end, edges;
    static int[][] family;
    static int[] dist;

    public static void dfs(int idx) {
        if (idx == end) {
            return;
        }
        for (int i = 1; i<=total; i++) {
            if (family[idx][i] == 1 && dist[i]==0) {
                dist[i] = dist[idx]+1;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        family = new int[total+1][total+1];
        dist = new int[total+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(br.readLine());

        for (int i=0; i<edges; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            family[x][y] = family[y][x] = 1;
        }

        dfs(start);
        System.out.println(dist[end] == 0 ? -1 : dist[end]);
    }

//    public static void main(String[] args) throws Exception {
//        new Main().solution();
//    }

}
