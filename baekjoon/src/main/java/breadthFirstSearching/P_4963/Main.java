package breadthFirstSearching.P_4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[][] grid;
    boolean[][] visited;
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    int count;
    int w, h, nowX, nowY;

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void solution() throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = " ";
        while (!(str = br.readLine()).equals("0 0")) {

            st = new StringTokenizer(br.readLine(), str);

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            grid = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                nowX = cur.x + dx[i];
                nowY = cur.y + dy[i];

                if (nowX >=0 && nowY >=0 && nowX < h && nowY < w && !visited[nowX][nowY] && grid[nowX][nowY] == 1) {
                    visited[nowX][nowY] = true;
                    q.add(new Node(nowX, nowY));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new depthFirstSearching.P_4963.Main().solution();
    }

}