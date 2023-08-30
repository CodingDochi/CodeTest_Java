package algorithmLesson.fibonacci.P_24417;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class OutOfMemory {

    /*
    입력 범위 : n(5 ≤ n ≤ 2 × 10^8) => int
    어떤 단위의 자료구조든, 인덱스로 쓸 수 있는 자료형은 int
    나눠야 할 수 : 1,000,000,007
     */
    BigInteger forRecur= BigInteger.valueOf(1);
    BigInteger forDp= BigInteger.valueOf(0);
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
            return (fib_recur(n.subtract(BigInteger.ONE)).add(fib_recur(n.subtract(BigInteger.valueOf(2)))));
        }
    }

    private BigInteger fib_dp(BigInteger n) {
        BigInteger[] f = new BigInteger[n.intValue() + 1];
        f[1] = f[2] = BigInteger.ONE;

        for (int i = 3; i <= n.intValue(); i++) {

            forDp = forDp.add(BigInteger.ONE);

            f[i] = f[i - 1].add(f[i - 2]);
        }
        return f[n.intValue()];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger bigN = new BigInteger(br.readLine());

        fib_recur(bigN);
        fib_dp(bigN);

        BigInteger resRecur = forRecur.mod(MOD);
        BigInteger resDp = forDp.mod(MOD);

        System.out.println(resRecur+" "+resDp);
    }

    public static void main(String[] args) throws Exception {
        new OutOfMemory().solution();
    }
}