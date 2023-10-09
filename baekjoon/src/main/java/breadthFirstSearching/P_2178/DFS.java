package breadthFirstSearching.P_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS {

    class Position {
        int row;
        int col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private boolean valid_range(int row, int col, int[][] maze) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) {
            return false;
        } else {
            return true;
        }
    }

    private int[][] newMaze(int row, int col, int[][] maze) {
        int[][] nm = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++)
                nm[i][j] = maze[i][j];
        nm[row][col] = 0;
        return nm;
    }

    private int move(Position pos, int[][] maze) {
        if (pos.row == maze.length && pos.col == maze[0].length)
            return 1;

        int[] row_move = {-1, 0, 1, 0};
        int[] col_move = {0, -1, 0, 1};
        Integer[] m = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < 4; i++) {
            int new_row = pos.row + row_move[i];
            int new_col = pos.col + col_move[i];
            int[][] nm = newMaze(pos.row, pos.col, maze);
            if (nm[new_row][new_col] == 0 || !valid_range(new_row, new_col, nm)) {
                continue;
            } else {
                Position p = new Position(new_row, new_col);
                m[i] = move(p, nm);
            }
        }

        if (Math.min(m[0], Math.min(m[1], Math.min(m[2], m[3]))) == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else
            return (Math.min(m[0], Math.min(m[1], Math.min(m[2], m[3])))) + 1;
    }


    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[N][M];
        for (int i=0; i < N; i++) {
            String content = br.readLine();
            for (int j=0; j < M; j++) {
                int num = Character.getNumericValue(content.charAt(j));
                maze[i][j] = num;
            }
        }
        int res = move(new Position(0, 0), maze);
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception{
        new DFS().solution();
    }
}