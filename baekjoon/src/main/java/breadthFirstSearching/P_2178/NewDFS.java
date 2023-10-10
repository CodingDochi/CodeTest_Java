package breadthFirstSearching.P_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

  /* maze[0][0] 에서 출발하여 maze[N-1][M-1]에 도착하는 경로 중 최소 이동

    maze[N-1][M-1] 에 이르는 최소 이동을 n 이라고 할 때,
    인접 블록인 maze[N-1][M-2], maze[N-2][M-1]에 이르는 최소 이동은 n-1 이다.
    maze[N-1][M-2]의 인접블록인 maze[N-1][M-3], maze[N-2][M-2]에 이르는 최소 이동은 n-2이다.
    maze[N-2][M-1]의 인접블록인 maze[N-2][M-2], maze[N-3][M-2]에 이르는 최소 이동은 n-2이다.

   각 위치 maze[i][j]에서 (0<i-1, i+1 <N, 0<j-1, j+1<M) 이동할 수 있는 방향은 4가지.
   maze[i+0][j+1], maze[i+0][j-1], maze[i+1][j+0], maze[i-1][j+0] 중에서 0이 아닌 경우만 이동을 지속한다.
    이동 시 상수 count를 +1 한다.

    이동 = 매 위치에서 시작되는 재귀 연산이며, 각 재귀 경로에서 값을 참조하거나 누적해야 할 것은 dp와 count 값이다. 어떤 경로를 거쳐왔든 dp[i][j]에는 항상 최소의 count만이 저장되어야 한다.

    dp는 모든 컨텍스트에서 참조할 수 있도록 재귀 함수의 바깥에 있어야 하고 count는 각 컨텍스트에서 누적할 수 있도록 재귀 함수 내부에 있어야 한다.

    dp[i+0][j+1], dp[i+0][j-1], dp[i+1][j+0], dp[i-1][j+0] 에 count를 저장할 때, dp 값이 0이 아니라면, 이전에 저장된 값과 현재 저장하려는 count 중 더 작은 쪽이 저장되도록 한다. i, j 또한 매 컨텍스트에서 누적 계산 되어야 하므로 재귀 함수 내부에 있어야 한다.

    만약 현재 저장하려는 count가 dp에 이미 저장되어 있는 값보다 크다면 이동을 중지한다.

    이 문제는 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어지는 조건이므로 도착 위치에 도달할 수 없는 경우는 생각하지 않아도 된다.
    return과 인풋을 명시하자
     */

public class NewDFS {

    int N;
    int M;
    int[][] dp;
    int[][] maze;

    private void dfs(int[][] maze, int count, int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) {
            return;
        }
        if (maze[row][col] == 0) {
            return;
        }
        if (maze[row][col] == 1) {
            count++;

            if ((dp[row][col] == 0) || (dp[row][col] >= count)) {
                dp[row][col] = count;

                dfs(maze, count, row, col + 1);
                dfs(maze, count, row, col - 1);
                dfs(maze, count, row+1, col);
                dfs(maze, count, row-1, col);
            }
        }
        if (row == N - 1 && col == M - 1) {
            return;
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        maze = new int[N][M];
        for (int i=0; i < N; i++) {
            String content = br.readLine();
            for (int j=0; j < M; j++) {
                int num = Character.getNumericValue(content.charAt(j));
                maze[i][j] = num;
            }
        }
        dfs(maze, 0, 0, 0);
        System.out.println(dp[N-1][M-1]);
    }

    public static void main(String[] args) throws Exception{
        new NewDFS().solution();
    }

}
