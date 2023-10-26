package depthFirstSearching.P_4963;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[][] grid;
    boolean[][] visited;
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};
    int count;
    int w, h;


    private void search(int x, int y) {
        visited[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (grid[nx][ny] == 1 && !visited[nx][ny]) {
                    search(nx, ny);
                }
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*
        while(w != 0 && h != 0) 이고 w, h의 입력 받는 부분이 while문 내부에 있는 경우 w와 h가 초기화되지 않은 상태에서 조건을 검사하게 되므로 코드 실행하자마자 종료됨. 따라서 while은 true 조건으로 하되 내부에서 종료 조건을 명시하도록 함.
         */
        while (true) {

            st = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            grid = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            System.out.println("w : " + w + " h : " + h);
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    System.out.print(grid[i][j] + " ");
//                }
//                System.out.println(); // 다음 행으로 넘어감
//            }
            // 출력을 제거하고 정답만 출력
            visited = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        search(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
