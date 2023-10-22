package depthFirstSearching.P_1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Refactored {
    static class Node {
        int ahead;
        int dist;

        Node(int ahead, int dist) {
            this.ahead = ahead;
            this.dist = dist;
        }
    }

    private int maxDistance = 0;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Node>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, dist));
            graph.get(to).add(new Node(from, dist));
        }

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            dfs(graph, i, 0, visited);
        }

        System.out.println(maxDistance);
    }

    private void dfs(List<List<Node>> graph, int start, int dist, boolean[] visited) {
        visited[start] = true;
        for (Node node : graph.get(start)) {
            if (!visited[node.ahead]) {
                int newDist = dist + node.dist;
                maxDistance = Math.max(maxDistance, newDist);
                dfs(graph, node.ahead, newDist, visited);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Refactored().solution();
    }
}