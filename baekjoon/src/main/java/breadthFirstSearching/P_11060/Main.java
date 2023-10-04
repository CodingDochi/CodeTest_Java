package breadthFirstSearching.P_11060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int N;
    int[] maze;

    static class Position {
        int idx, cnt;
        Position(int idx, int cnt) {
            this.idx = idx; // 현 위치 인덱스
            this.cnt = cnt; // 현 위치까지 점프 회수
        }
    }

    private int search() {
        Queue<Position> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        queue.add(new Position(0, 0));
        while(!queue.isEmpty()) {
            Position cur = queue.poll();
            if (cur.idx >= N-1) {
                return cur.cnt;
            }
            for (int i=1; i <= maze[cur.idx]; i++) {
                int next_idx = cur.idx + i;
                if(next_idx < N && !visited[next_idx]) {
                    visited[next_idx] = true;
                    queue.add(new Position(next_idx, cur.cnt + 1));
                }
            }
        }
        return -1;

    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        maze = new int[N];
        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int res = search();
        System.out.println(res);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
