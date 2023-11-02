package dynamicProgramming.P_14606;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    /*
            분리 방식                  분리 기쁨(분리 수끼리 곱함)           누적 기쁨
    상자 0개   없음                      0                               0
    상자 1개   없음                      0                               0
    상자 2개 [[1,1]]                    1*1 = 1                         1 + 기쁨(1) = 1+0 = 1;
    상자 3개 [[1,2]]                    1*2 = 2                         2 + 기쁨(2) = 2+1 = 3;
    상자 4개 [[1,3], [2,2]]             1*3 = 3, 2*2 = 4                3 + 기쁨(3) = 3+3 = 6; 4 + 기쁨(2) + 기쁨(2) = 4+1+1 = 6;
    상자 5개 [[1,4], [2,3]]             1*4 = 4, 2*3 = 6                4 + 기쁨(4) = 4+6 = 10; 6 + 기쁨(2) + 기쁨(3) = 6+1+3 = 10;
    상자 6개 [[1,5], [2,4], [3,3]]      1*5 = 5, 2*4 = 8, 3*3 = 9       5 + 기쁨(5) = 5+10 = 15; 8 + 기쁨(2) + 기쁨(4) = 8+1+6 = 15; 9 + 기쁨(3) + 기쁨(3) = 9+3+3 = 15;

    N개를 어떤 식으로 분리하든 상자 분리시의 누적 기쁨은 같다.
    점화식을 만들기 위해 분리 방식은 (N-1)*1 로 통일한다.
     */

    private int accumulate_joy(int N) {

        int[] max_res = new int[N+1];
        max_res[0] = 0;

        for (int i = 1; i <=N; i++) {
            max_res[i] = (i-1)*1 + max_res[i-1];
        }
        System.out.println(max_res[N]);
        return max_res[N];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        accumulate_joy(N);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
