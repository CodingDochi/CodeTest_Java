package algorithmLesson.fibonacci.P_24416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    int forRecur=1;
    int forDp=0;

    private int fib_recur(int n) {
        if (n==1 | n==2) {
            return 1;
        }
        else {
            forRecur++;
            return (fib_recur(n-1) + fib_recur(n-2));
        }
    }

    private int fib_dp(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i=3; i<=n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        forDp = n - 2;
        return f[n];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        fib_recur(N);
        fib_dp(N);
        System.out.println(forRecur+" "+forDp);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
