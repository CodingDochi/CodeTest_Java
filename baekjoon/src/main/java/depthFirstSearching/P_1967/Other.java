package depthFirstSearching.P_1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Other {

    class Node {
        int vertex;
        int dist;
        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    ArrayList<Node>[] list_arr;
    boolean[] visited;
    int n;
    int max_vertex;
    int max_dist;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list_arr = new ArrayList[n+1];
        for(int i = 0; i <=n; i++) {
            list_arr[i] = new ArrayList<>();
        }

        for (int i=0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list_arr[parent].add(new Node(child,weight));
            list_arr[child].add(new Node(parent,weight));
        }

        // 루트 기준으로 dfs를 진행하여 가장 큰 가중치를 가진 노드를 구하고
        // 이 노드를 기준으로 dfs를 실행한다.

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n+1];
        visited[max_vertex] = true;
        dfs(max_vertex, 0);
        System.out.println(max_dist);
    }

    private void dfs(int vertex, int dist) {
        if (max_dist < dist) {
            max_dist = dist;
            max_vertex = vertex;
        }
        for (Node node : list_arr[vertex]) {
            if(!visited[node.vertex]) {
                visited[node.vertex] = true;
                dfs(node.vertex, dist+node.dist);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Other().solution();
    }
}
