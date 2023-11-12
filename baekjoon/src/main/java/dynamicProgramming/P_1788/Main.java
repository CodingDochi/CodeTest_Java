package dynamicProgramming.P_1788;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /*
    0 1 2 3 4 5 6 7
    0 1 1 2 3 5 8 13
     */

    int[] dp;

    private int[] init_dp(int M) {
        dp = new int[M + 1];
        for (int i = 0; i <= M; i++) {
            if (i == 0) {
                dp[i] = 0;
            }
            if (i == 1 || i == 2) {
                dp[i] = 1;
            }
        }
        return dp;
    }

    private int fibo(int M, int[] dp) {

        for (int i = 3; i <= M; i++) {
            int tmp = dp[i - 1];
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
            dp[i - 1] = tmp;

        }
        return dp[M];
    }

    /*
    위 코드에서 (dp[i-1] + dp[i-2]) % 1000000000 부분은 합을 구한 후 1,000,000,000으로 나눈 나머지를 구하는 것입니다. 이 작업은 정수 오버플로우를 방지하고 계산 결과를 10억으로 제한하기 위한 것입니다.
     */

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Math.abs(N);

        if (N ==0 && M==0) {
            System.out.println(0);
        }
        else {
            if (N < 0 && M % 2 ==0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        }

        init_dp(M);
        System.out.println(fibo(M, dp));

    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
