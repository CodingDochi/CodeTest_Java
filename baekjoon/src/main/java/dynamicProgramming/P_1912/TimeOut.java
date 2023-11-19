package dynamicProgramming.P_1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TimeOut {

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int j = 0; j<=n; j++) {
            for (int k = n; k >=j+1; k--) {
                if (arr[k] - arr[j] > max) {
                    max = arr[k] - arr[j];
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new TimeOut().solution();
    }
}