package dfsAndBfs.Lessons_43162;

import java.util.LinkedList;
import java.util.Queue;

public class Other {

    public int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(computers, visited, i);
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }

    private void bfs(int[][] computers, boolean[] visited, int v) {
        Queue<Integer> q = new LinkedList<>();
        visited[v] = true;
        q.add(v);

        while(!q.isEmpty()) {
            Integer w = q.poll();
            for (int i=0; i< computers.length; i++) {
                if (computers[w][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] computers_a = {{1, 1, 0}, {1, 1, 0},{0, 0, 1}};
        int[][] computers_b = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] computers_c = {{1, 0, 0, 1}, {0, 1, 1, 0},{0, 1, 1, 0}, {1, 1, 0, 1}};
        int[][] computers_d = {{1, 1, 0, 0}, {1, 1, 0, 0},{0, 0, 1, 1}, {0, 0, 1, 1}};

        int n = 4;

        new Other().solution(n, computers_d);
    }

}
