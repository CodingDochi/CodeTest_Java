package dynamicProgramming.P_1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.min;

public class Main {

    /*
    제곱수를 최소로 사용한 합으로 입력된 숫자를 만들기

    * 반대로 생각해보기

    제곱수를 최대로 사용한 합으로 숫자를 만들려면?
    1^2 * N = N

    dp[N]에는 N을 만들 수 있는 항의 최소 개수이다.
    1로 시작한다면 dp[43]=43

    1 ~ N 범위에서 N보다 작은 제곱수를 가장 작은 것부터 차례로 대입하여 뺀다.

   dp[43 - 1^2] = dp[42]
   dp[43]은 dp[42] 즉 42를 제곱수의 합으로 나타낼 때 최소항의 개수에, 제곱수 1을 더한 값이다.

  이를 추상화하면 dp[N - a^2] = dp [N - a^2] 라고 표현할 수는 없고, dp[N - a^2]는 (N - a^2)를 제곱수의 합으로 나타낼 때 최소항의 개수에, 어떤 제곱수의 항 1개를 더한 것이므로 dp[N - a^2] = dp [N - a^2] + 1 이며,

   작은 값부터 최소항의 수를 기록하는 bottom-up 방식을 사용하면서 값을 생성 및 수정할 때 기존 값과 새 값 중 작은 것을 선택하도록 한다.
     */

    int N;
    private int[] sqrt_comb_list (int N) {
        int[] min_amount_sqrt = new int[(N+1)];
        for (int i = 0; i <=N; i++) {
            min_amount_sqrt[i] = i;
        }
        for (int i=1; i<=N; i++) {
            for (int j=1; (j*j)<=i; j++) {
                min_amount_sqrt[i] = min(min_amount_sqrt[i], min_amount_sqrt[i-(j*j)]+1);
            }
        }
        System.out.println(min_amount_sqrt[N]);
        return min_amount_sqrt;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sqrt_comb_list(N);
    }
    public static void main (String[] args) throws Exception {
        new Main().solution();
    }

}
