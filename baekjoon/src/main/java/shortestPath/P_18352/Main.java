package shortestPath.P_18352;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    // 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X, 모든 도로의 거리는 1
    // A번 도시에서 B번 도시로 이동하는 `단방향` 도로는 M개의 줄에 걸쳐서 두 개의 서로 다른 자연수 A, B로 주어짐

    int N, M, K, X;
    List<Integer> distances;
    List<List<Integer>> one_way_path;
    List<Boolean> visited;
    StringBuilder sb = new StringBuilder();

    private void distance_K (List<Integer> distances) {
        for (int i = 0; i <= N; i++) {
            if (distances.get(i) == K) {
                sb.append(i).append("\n");
            }
        }
        if (sb.length()==0) {
            sb.append(-1);
        }
    }

    private List<Integer> shortest_path(int start_elem) {
        Queue<Integer> vertex_visit = new LinkedList<>();
        vertex_visit.add(start_elem);
        visited.set(start_elem, true);
        distances.set(start_elem, 0);

        while (!vertex_visit.isEmpty()) {
            int cur_elem = vertex_visit.poll();

            for(int dest_elem : one_way_path.get(cur_elem)) {
                if (!visited.get(dest_elem)) {
                    visited.set(dest_elem, true);
                    distances.set(dest_elem, distances.get(cur_elem)+1);
                    vertex_visit.add(dest_elem);
                }
                distances.set(dest_elem, Math.min(distances.get(dest_elem), distances.get(cur_elem)+1));
            }
        }
//        System.out.println("distances : "+distances.toString());
        return distances;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        one_way_path = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            one_way_path.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            one_way_path.get(start).add(dest);
        }

        distances = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            distances.add(300001);
        }

        distances.set(X, 0);

        visited = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            visited.add(false);
        }

        distance_K(shortest_path(X));
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
