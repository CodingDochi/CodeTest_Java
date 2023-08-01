package algorithmLesson.asymtoticNotation.P_24313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int a1;
    private int a0;
    private int c;
    private int n0;
    private int result;

    /*

    (1 ≤ c ≤ 100),
    (1 ≤ n0 ≤ 100),
    (0 ≤ |ai| ≤ 100)

    f(n) = a1 * n + a0
    g(n) = n

    O(n)의 정의는 주어지는 모든 n(n>= n0)에 대해
    c * g(n) > = f(n) 가 항상 성립하는
    양의 정수 c와 n0의 존재이다.

                           c-------->c
                           n--------------->
                          n0-------->n0
       |---------|----|----|---------|
    (-100)     (-1)   0    1        100
      ai---------------------------->ai

    c * n >= a1 * n + a0
    (c - a1) * n >= a0

    (i) c = a1 일 때, a0 <= 0 이어야 성립
    (ii) c - a1 = 1일 때, a0 <= n 이어야 성립

    (i)의 조건부분에서 c, n 전 범위 수용 가능하지만, 결과부분은 c, n에 의해 결정될 수 없다.
    (ii)의 결과부분은 입력으로 주어질 n의 전범위를 포함하며, (i)의 결과부분도 포함한다. (ii)만의 조건 부분은 c > a1과 같지만 (i)의 결과부분도 포함하므로 (i)의 조건 부분까지 고려하여 새로운 조건식 (iii)을 만들 수 있다.

    (iii) c >= a1

     */

    private int f(int n) {
        return a1 * n + a0;
    }

    private int g(int n) {
            return n;
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());

        if ((f(n0) <= c * g(n0)) && (c>=a1)) {
            result = 1;
        }
        else {
            result = 0;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
