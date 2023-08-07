package algorithmLesson.asymtoticNotation.P_24368;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Other {

    private int a2;
    private int a1;
    private int a0;
    private int n0;


    private int f (int n) {
        return a2 * n * n + a1 * n + a0;
    }

    private int g(int n) {
        return n * n;
    }

    private List<Integer> reverseSignList (List<Integer> numlist) {
        List<Integer> rv_list = new ArrayList<>();
        for (int num : numlist) {
            rv_list.add(num * (-1));
        }
        return rv_list;
    }

    private List<List<Integer>> divisorList (int a) {
        List<Integer> forward = new ArrayList<>();
        List<Integer> backward = new ArrayList<>();
        for (int i=1; i <= a/2; i++) {
            if (((double) a / (double) i) == ((int) a / (int) i)) {
                forward.add(i);
                backward.add(a / i);
            }
        }

        List<Integer> rv_forward = reverseSignList(forward);
        List<Integer> rv_backward = reverseSignList(backward);

        List<List<Integer>> result = new ArrayList<>();
        result.add(forward);
        result.add(rv_forward);
        result.add(backward);
        result.add(rv_backward);
        return result;
    }







    private boolean expressionDivider(int c, int n) {
        if (base(c, n) && ((a2 == c) && (0 >= (a1 * n + a0)))) {

            if (((a0 < 0) && (a1 > 0)) || ((a0 > 0) && (a1 < 0))) {
                return Math.abs(a1 * n) >= Math.abs(a0);
            } else if (((a0 > 0) && (a1 > 0)) || ((a0 < 0) && (a1 < 0))) {
                return false;
            } else if (a0 == 0) {
                return a1 >= 0;
            }

            if (a1 == 0) {
                return a0 >= 0;
            }
        }
        if (base(c, n) && ((c - a2 >= 1) && (1 >= (a1 * n + a0)))) {

            if (((a0 > 0) && (a1 > 0)) || ((a0 < 0) && (a1 < 0))) {



            }

        }
        return false;
    }



    private boolean base (int c, int n) {
        return ((n >= n0) && (1 <= n0) && ( n0 <=100)) && ((1 <= c) && ( c <=100));
    }
    private boolean condition(int c, int n) {
        return ((c - a2) * n * n >= (a1 * n + a0)) && (f(n) <= c * g(n));
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a2 = Integer.parseInt(st.nextToken());
        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (base(c, n0) && condition(c, n0)) {
            sb.append(1);
        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }

}
