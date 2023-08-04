package algorithmLesson.asymtoticNotation.P_24315;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
/*
Θ(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 c1 × g(n) ≤ f(n) ≤ c2 × g(n)인 양의 상수 c1, c2, n0가 존재한다}

빅 세타 표기법은 시간 복잡도를 나타내는 함수의 상한과 하한을 모두 나타낸다. 즉 상한(빅 오)과 하한(빅 오메가)의 교집합

 */

    private int a0;
    private int a1;

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

        st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int n0 = Integer.parseInt(br.readLine());

        int result;

        if (((f(n0)>= c1 * g(n0)) && (c1<=a1)) && ((f(n0) <= c2 * g(n0)) && (c2>=a1))) {
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
