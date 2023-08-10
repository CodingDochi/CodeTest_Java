package algorithmLesson.breadthFirstSearch.P_24444;

import java.io.*;
import java.util.*;


public class OutOfMemory {

    int N;
    int M;
    int R;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int[][] E = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            E[i] = new int[N + 1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            E[u][v] = 1;
            E[v][u] = 1;
        }

        bfs(E, R);
    }

    private void bfs (int[][] E, int R) throws IOException {

        Queue<Integer> vertex_visit = new LinkedList<Integer>();

        int[] visited = new int[N + 1];
        for (int v = 1; v < N + 1; v++) {
            visited[v] = 0;
        }

        visited[R] = 1;
        vertex_visit.add(R);
        int cnt = 1;

        while (!vertex_visit.isEmpty()) {
            int u = vertex_visit.poll();

            for (int v = 1; v < N + 1; v++) {
                if ((v != R) && (E[u][v] == 1 && visited[v] == 0)){
                    visited[v] = ++cnt;
                    vertex_visit.add(v);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v = 1; v < N; v++) {
            sb.append(v+"\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new OutOfMemory().solution();
    }
}
