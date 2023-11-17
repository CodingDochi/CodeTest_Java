package dynamicProgramming.P_1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    private void find_max(int n, int[] nums) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        int max = nums[1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        find_max(n, nums);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
