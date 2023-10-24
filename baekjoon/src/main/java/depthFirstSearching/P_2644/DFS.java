package depthFirstSearching.P_2644;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class DFS {

    class Node {
        List<Integer> routes = new ArrayList<>();
    }

    int total;
    int[] visited;
    int start, end;
    int edges;
    int cnt = 0;

    Node[] family;
    boolean[] visits;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        visited = new int[total + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(br.readLine());

        family = new Node[total + 1];
        visits = new boolean[total + 1];

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

        System.out.println(traverse(start, end, 0));
    }

    public int traverse(int now, int end, int cnt) {
        if (now == end) {
            return cnt;
        }

        int min = -1;
        Node currentNode = family[now];

        for (int next : currentNode.routes) {
            if (visits[next]) {
                continue;
            }
            visits[next] = true;
            int result = traverse(next, end, cnt + 1);
            visits[next] = false;
            if (min == -1 || result != -1 && result < min) {
                min = result;
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        new DFS().solution();
    }
}