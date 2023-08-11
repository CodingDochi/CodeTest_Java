package algorithmLesson.breadthFirstSearch.P_24444;

import java.util.*;
import java.io.*;

public class UsingArray {
    private ArrayList<Integer>[] nodes;

    public static void main(String[] args) throws IOException {
        new UsingArray().solution();
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N + 1];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");

            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            nodes[start].add(end);
            nodes[end].add(start);
        }
        for (ArrayList<Integer> node : nodes) {
            node.sort(null);
        }
        bfs(R, sb);

        System.out.println(sb);
    }

    private void bfs(int start, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[nodes.length];
        int[] orders = new int[nodes.length];
        int cnt = 1;

        visit[start] = true;
        queue.add(start);
        orders[start] = cnt++;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ArrayList<Integer> node = nodes[now];
            for (int dest : node) {
                if (visit[dest]) {
                    continue;
                }
                visit[dest] = true;
                orders[dest] = cnt++;
                queue.add(dest);
            }

        }
        for (int i = 1; i < orders.length; i++) {
            sb.append(orders[i]).append('\n');
        }
    }
}