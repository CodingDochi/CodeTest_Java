package algorithmLesson.matrixPath.P_24418;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int dp_cnt = 0;
    int recur_cnt = 1;

    private void print_out_cnt(int recur_cnt, int dp_cnt){
        System.out.println(recur_cnt);
        System.out.println(dp_cnt);
    }
    private int matrix_path_rec(int[][] m, int i, int j) {

        if (i==0 || j==0){
            return 0;
        } else {
            recur_cnt++;
            return (m[i][j] + Math.max(matrix_path_rec(m, i-1, j), matrix_path_rec(m, i, j-1)));
        }
    }

    private int matrix_path_dp(int[][] m, int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
            dp_cnt++;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 0;
            dp_cnt++;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = m[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
                dp_cnt++;
            }
        }
        return dp[n][n];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] m = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        matrix_path_rec(m, n, n);
        matrix_path_dp(m, n);
        print_out_cnt(recur_cnt, dp_cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
