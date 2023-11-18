package dynamicProgramming.P_1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Retry {

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max_num = nums[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(nums[i]+dp[i-1], nums[i]);
            max_num = Math.max(dp[i], max_num);
        }

        System.out.println(max_num);
    }
    public static void main(String[] args) throws Exception {
        new Retry().solution();
    }
}
