package depthFirstSearching.P_1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Other {

    class Node {
        int vertex;
        int dist;
        Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    int V;
    ArrayList<Node>[] list_arr;
    boolean[] visited;
    int max_dist = 0;
    int max_vertex = 0;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        list_arr = new ArrayList[V+1];

        for (int i=0; i<=V; i++) {
            list_arr[i] = new ArrayList<>(); // 각 요소를 ArrayList 객체로 초기화
        }

        for (int i=0; i<V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int ahead, weight;

            // Java의 while문에서 할당과 동시에 조건 평가가 가능.
            while((ahead = Integer.parseInt(st.nextToken()))!= -1 && (weight = Integer.parseInt(st.nextToken())) != -1) {
                list_arr[cur].add(new Node(ahead, weight));
            }
        }

        // 예시로 리스트 출력
//        for (int i = 1; i <= V; i++) {
//            System.out.print("List for node " + i + ": ");
//            for (Node node : list_arr[i]) {
//                System.out.print("(" + node.vertex + ", " + node.dist + ") ");
//            }
//            System.out.println();
//        }

        visited = new boolean[V+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[V+1];
        visited[max_vertex] = true;
        dfs(max_vertex, 0);
        System.out.println(max_dist);
    }

    private void dfs(int vertex, int dist) {
        if(max_dist < dist) {
            max_dist = dist;
            max_vertex = vertex;
        }

        for (Node node : list_arr[vertex]) {
            if(!visited[node.vertex]) {
                visited[node.vertex]=true;
                dfs(node.vertex, dist+node.dist);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Other().solution();
    }

}
