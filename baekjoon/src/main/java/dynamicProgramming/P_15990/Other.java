package dynamicProgramming.P_15990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Other {
    static long[][] arr = new long[100001][4];
    static int MOD = 1000000009;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr[1][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;
        for(int i=4;i<100001;i++){
            arr[i][1] = (arr[i-1][2] + arr[i-1][3]) % MOD;
            arr[i][2] = (arr[i-2][1] + arr[i-2][3]) % MOD;
            arr[i][3] = (arr[i-3][1] + arr[i-3][2]) % MOD;
        }
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int num = Integer.parseInt(br.readLine());
            long result = (arr[num][1] + arr[num][2] + arr[num][3]) % MOD;
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}