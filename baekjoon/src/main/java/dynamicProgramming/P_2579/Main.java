package dynamicProgramming.P_2579;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    int N;
    int[] dp;

    private int dynamic_res(int N, List<Integer> stairs) {

        // i = 0 => stairs[0] : dp[0]
        // i = 1 => stairs[1] : dp[1] 1번째 계단에서의 최대값
        // i = 2 => stairs[2] : dp[2] 2번째 계단에서의 최대값
        // i = 3 => stairs[1] + stairs[3] : dp[1] + stairs[3] = dp[3]
        //       => stairs[2] + stairs[3] : dp[2] + stairs[3] = dp[3]
        // i = 4 => stairs[4] + ( dp[3] = dp[1] + stairs[3] )
        //       => stairs[4] + ( dp[2] = stairs[2] )

        dp[0] = stairs.get(0);
        dp[1] = stairs.get(1);
        dp[2] = stairs.get(1)+stairs.get(2);

        for (int i = 3; i < N+1; i ++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs.get(i-1))+ stairs.get(i);
        }
        return dp[N];
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        List<Integer> stairs = new ArrayList<>();
        stairs.add(0);
        for (int i = 1; i < N+1; i ++) {
            stairs.add(Integer.parseInt(br.readLine()));
        }
//        System.out.println(stairs.toString());

        dp = new int[N+1];
        if (N == 1) {
            dp[0] = stairs.get(0);
            dp[1] = stairs.get(1);
            System.out.println(dp[1]);
        }
        if (N == 2) {
            dp[0] = stairs.get(0);
            dp[1] = stairs.get(1);
            dp[2] = stairs.get(1) + stairs.get(2);
            System.out.println(dp[2]);
        }
        if (N >= 3) {
            System.out.println(dynamic_res(N, stairs));
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
