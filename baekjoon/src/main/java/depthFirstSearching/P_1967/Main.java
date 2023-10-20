package depthFirstSearching.P_1967;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    class Node {
        int ahead;
        int dist;
        Node(int ahead, int dist) {
            this.ahead = ahead;
            this.dist = dist;
        }
    }

    List<List<Node>> graph;
    List<Boolean> visited;
    int max_dist_for_cur = 0;
    int max_dist_for_total = 0;
    int n;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            List<Node> sub_tree = new ArrayList<>();
            graph.add(sub_tree);
            visited.add(false);
        }

        // 간선 정보 n-1 개 입력 : 부모 노드 작은 순, 자식 노드 작은 순, 루트 = 1
        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()); // 부모 노드
            int to = Integer.parseInt(st.nextToken()); // 자식 노드
            int dist = Integer.parseInt(st.nextToken()); // 가중치
            graph.get(from).add(new Node(to, dist));
            graph.get(to).add(new Node(from, dist));
        }

//        System.out.println("Node information:");
//        for (int i = 1; i <= n; i++) {
//            System.out.print("Node " + i + ": ");
//            for (Node node : graph.get(i)) {
//                System.out.print("(" + node.ahead + ", " + node.dist + ") ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i<=n; i++) {
            visited.set(i, true);
            dfs(i,0);
            visited.set(i, false);
            max_dist_for_total = Math.max(max_dist_for_total, max_dist_for_cur);
        }
        System.out.println(max_dist_for_total);
    }

    private void dfs(int start, int dist) {
        for (Node node : graph.get(start)) {
            if (!visited.get(node.ahead)) {
                visited.set(node.ahead, true);
                dfs(node.ahead, dist + node.dist);
                visited.set(node.ahead, false);
            }
            max_dist_for_cur = Math.max(max_dist_for_cur, dist);
//            System.out.println("max_cur : "+ max_dist_for_cur+"   dist : "+dist+"   start : "+start+"   node.ahead : "+node.ahead);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
