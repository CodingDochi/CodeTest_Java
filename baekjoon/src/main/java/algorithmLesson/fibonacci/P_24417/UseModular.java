package algorithmLesson.fibonacci.P_24417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class UseModular {
    BigInteger forRecur= BigInteger.valueOf(1);
    int forDp = 0;
    BigInteger MOD = BigInteger.valueOf(1000000007);

    private BigInteger fib_recur(BigInteger n) {

        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.valueOf(2))) {
            return BigInteger.ONE;
        }

        /*
        BigInteger.TWO는 BigInteger 클래스의 static final임.
        내부에서 new BigInteger("2")를 생성하므로
        BigInteger.TWO 호출 시마다 매번 새로운 객체가 생성되는 것.
        BigInteger.valueOf(2)는 캐싱되어 있는 객체 반환.
        효율을 위해 캐싱되니 객체 재사용 권장
        */

        else {
            forRecur = forRecur.add(BigInteger.ONE);
            return (fib_recur(n.subtract(BigInteger.ONE)).add(fib_recur(n.subtract(BigInteger.valueOf(2)))).mod(MOD));
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

        fib_recur(BigInteger.valueOf(intN));
        fib_dp(intN);

        BigInteger resRecur = forRecur.mod(MOD);
        BigInteger resDp = BigInteger.valueOf(forDp).mod(MOD);

        System.out.println(resRecur+" "+resDp);
    }

    public static void main(String[] args) throws Exception {
        new UseModular().solution();
    }

}