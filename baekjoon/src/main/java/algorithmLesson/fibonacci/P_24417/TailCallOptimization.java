package algorithmLesson.fibonacci.P_24417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TailCallOptimization {

    BigInteger forRecur = BigInteger.valueOf(0);
    int forDp = 0;
    BigInteger MOD = BigInteger.valueOf(1000000007);

    /*
    꼬리 재귀 최적화를 사용한 피보나치 함수
    일반 재귀로 풀이한 피보나치 함수에서는, 재귀 호출 후,
    그 내부에서 추가적으로 재귀 호출 및 덧셈 연산을 요구하는 반면,
    꼬리 재귀로 구현된 함수는 마지막 단 한번의 재귀 연산만이 요구된다.
     */

    private BigInteger fibTailRec(BigInteger n, BigInteger a, BigInteger b) {
        forRecur = forRecur.add(BigInteger.ONE);
        if (n.equals(BigInteger.ZERO)) {
            return a;
        }
        if (n.equals(BigInteger.ONE)) {
            return b;
        }
        return fibTailRec(n.subtract(BigInteger.ONE), b, a.add(b));
    }
    private int fib_dp(int n) {

        int[] f = new int[n + 1];

        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            forDp++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int intN = Integer.parseInt(br.readLine());

        fibTailRec(BigInteger.valueOf(intN), BigInteger.ZERO, BigInteger.ONE);
        fib_dp(intN);

        BigInteger resRecur = forRecur.mod(MOD);
        BigInteger resDp = BigInteger.valueOf(forDp).mod(MOD);

        System.out.println(resRecur + " " + resDp);
    }

    public static void main(String[] args) throws Exception {
        new TailCallOptimization().solution();
    }

}

