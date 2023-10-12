package breadthFirstSearching.P_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {

    class Node {
        List<Integer> routes = new ArrayList<>();
    }

    int total;
    int start, end;
    int edges;
    int cnt = 0;

    Node[] family;
    boolean[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(br.readLine());

        family = new Node[total + 1];
        visited = new boolean[total + 1];

        for (int i = 1; i <= total; i++) {
            family[i] = new Node();
        }

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            Node parentNode = family[parent];
            Node childNode = family[child];
            parentNode.routes.add(child);
            childNode.routes.add(parent);
        }

        System.out.println(traverse(start, end));
    }

    public int traverse(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int sameLevelNodes = queue.size();
            for(int i = 0; i < sameLevelNodes; i++) {
                int cur= queue.poll();
                if (cur == end) {
                    return cnt;
                }
                Node curNode = family[cur];
                for (Integer linked : curNode.routes) {
                    if (!visited[linked]) {
                        visited[linked] = true;
                        queue.add(linked);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        new BFS().solution();
    }
}
