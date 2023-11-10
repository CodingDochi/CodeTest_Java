package dynamicProgramming.P_1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Retry {

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        for (int i = 0; i<= N; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
            }
        }

        System.out.println(dp[N]);

    }
    public static void main(String[] args) throws Exception {
        new Retry().solution();
    }

}
