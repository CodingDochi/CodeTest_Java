package dynamicProgramming.P_1904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /*
    0은 00 두개 붙여 써야 하고 1은 1개씩 쓸 수 있음.
    이 조합으로 가능한 이진 수열의 길이

    n = 1 : 1개 : 1
    n = 2 : 2개 : 11, 00
    n = 3 : 3개 : 111, 100, 001
    n = 4 : 5개 : 1111, 1100, 1001, 0011, 0000,
    n = 5 : 8개 : 11111, 11100, 11001, 10011, 00111, 10000,00100, 00001
    n = 6 : 13개 : 111111, 111100, 111001, 110011, 100111, 001111, 110000, 100100, 100001, 001100, 001001, 000011, 000000

    형성 가능한 이진수열의 개수가 피보나치 수열의 형태로 증가하고 있다.
     */

    int N;

    private int[] init_dp(int N) {
        int[] dp = new int[N+1];
        if (N == 0) {
            dp[0] = 0;
        }
        if (N == 1) {
            dp[0] = 0;
            dp[1] = 1;
        }
        if (N >= 2) {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
        }
        return dp;
    }
    private int fibo_tile(int N) {
        int[] dp = init_dp(N);

        for (int i = 3; i < N+1; i++) {
            dp[i] = (dp[i - 1]% 15746 + dp[i - 2]% 15746)%15746;
        }
        return dp[N];
    }

    private void solution () throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(fibo_tile(N));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
