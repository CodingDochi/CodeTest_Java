package algorithmLesson.asymtoticNotation.P_24368;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int a2;
    private int a1;
    private int a0;
    private int n0;
    private boolean res;

    private int f(int n) {
        return a2 * n * n + a1 * n + a0;
    }

    private int g(int n) {
        return n * n;
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
        boolean result;

        if (c == a2) {
            System.out.println(1);
        }
        if ((c == a1) && (n0 != 1)) {
            System.out.println(1);
        } else {System.out.println(0);}
        if ((c <= a1) && (a0 < 0) && (a1 > 0) && (n0 == 1)) {
            System.out.println(0);
        }System.out.println(1);
    }


    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}


