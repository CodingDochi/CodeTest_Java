package dynamicProgramming.P_11726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private int[] init_dp (int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i <=n; i++){
            if (i ==0) {
                dp[0] = 0;
            }
            if (i == 1 | i == 2) {
                dp[i] = i;
            }
        }
        return dp;
    }

    private int count_block(int n, int[]dp) {
        for (int i = 3; i <=n; i++) {
            int tmp = dp[i-1];
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            dp[i-1] = tmp;
        }
        return dp[n];
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = init_dp(n);
        System.out.println(count_block(n, dp));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}