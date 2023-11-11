package dynamicProgramming.P_1699;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class WrongIdea {

    /* 잘못된 풀이

    단순하게 자연수 N보다 작은 제곱수들 중 가장 큰 것으로만 빼서 계산한다면 틀리게 됩니다.

    테스트 케이스 : 43은 36을 뺐을 때가 아닌 25를 뺐을 때 최소항 개수를 가짐.
     */


    private long[] make_sqrt_list (long N) {
        long[] sqrt_in_range = new long[(int)(N+1)];

        for (long i = 1; i <= N; i++) {
            if (i * i <= N ) {
                sqrt_in_range[(int)(i*i)] = 1;
            }
        }
        return sqrt_in_range;
    }

    private long cnt = 0;
    private long calculate (long N, long[] sqrt_in_range) {
        long remain = N;

        for (long i = N; i > 0; i--) {

            if (remain == 0) {
                System.out.println("1  remain : "+remain+"   cnt : "+cnt+"  i : "+i);
                return cnt;
            } else {

                if (i == 1) {
                    cnt += remain;
                    System.out.println("2  remain : "+remain+"   cnt : "+cnt+"  i : "+i);
                    return cnt;
                }

                if (sqrt_in_range[(int)i] == 1 && i > 1) {
                    remain -= i;
                    cnt++;
                    i = remain + 1;
                    System.out.println("3  remain : "+remain+"   cnt : "+cnt+"  i : "+i);
                }
                if ((sqrt_in_range[(int)i] != 1 && i > 1) && (4 > i)) {
                    cnt += remain;
                    System.out.println("4  remain : "+remain+"   cnt : "+cnt+"  i : "+i);

                    return cnt;
                }
            }
        }
        System.out.println("5  remain : "+remain+"   cnt : "+cnt);
        return cnt;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        calculate(N, make_sqrt_list(N));
    }
    public static void main (String[] args) throws Exception {
        new WrongIdea().solution();
    }
}
