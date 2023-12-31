package dfsAndBfs.Lessons_43162;

import java.util.Stack;

public class Another {

    public int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }

    private void dfs(int[][] computers, boolean[] visited, int v) {
        Stack<Integer> stack = new Stack<>();
        visited[v] = true;
        stack.push(v);

        while(!stack.isEmpty()) {
            Integer w = stack.peek();
            visited[w] = true;

            boolean hasAdjNode = false; // 방문하지 않은 노드가 있는지
            for(int i=0; i<computers.length; i++) {
                if(computers[w][i] ==1 && !visited[i]) {
                    visited[i] = true;
                    hasAdjNode = true;
                    stack.push(i);
                    break;
                }
            }
            if(!hasAdjNode) {
                stack.pop();
            }
        }
    }
    public static void main(String[] args) {
        int[][] computers_a = {{1, 1, 0}, {1, 1, 0},{0, 0, 1}};
        int[][] computers_b = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] computers_c = {{1, 0, 0, 1}, {0, 1, 1, 0},{0, 1, 1, 0}, {1, 1, 0, 1}};
        int[][] computers_d = {{1, 1, 0, 0}, {1, 1, 0, 0},{0, 0, 1, 1}, {0, 0, 1, 1}};

        int n = 4;

        new Another().solution(n, computers_d);
    }
}
