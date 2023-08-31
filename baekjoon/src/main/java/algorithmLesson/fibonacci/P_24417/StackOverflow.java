package algorithmLesson.fibonacci.P_24417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class StackOverflow {

    /*
    입력 범위 : n(5 ≤ n ≤ 2 × 10^8) => int
    어떤 단위의 자료구조든, 인덱스로 쓸 수 있는 자료형은 int
    나눠야 할 수 : 1,000,000,007
     */
    int forRecur = 1;
    int forDp = 0;
    BigInteger MOD = BigInteger.valueOf(1000000007);

    private int fib_recur(int n) {

        if (n==1 || n==2) {
            return 1;
        }
        else {
                forRecur++;
            return fib_recur(n-1)+fib_recur(n-2);
        }
    }

    private int fib_dp(int n) {

        int[] f = new int[n+1];

        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            forDp++;
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int intN = Integer.parseInt(br.readLine());

        fib_recur(intN);
        fib_dp(intN);

        BigInteger resRecur = BigInteger.valueOf(forRecur).mod(MOD);
        BigInteger resDp = BigInteger.valueOf(forDp).mod(MOD);

        System.out.println(resRecur+" "+resDp);
    }

    public static void main(String[] args) throws Exception {
        new StackOverflow().solution();
    }
}

