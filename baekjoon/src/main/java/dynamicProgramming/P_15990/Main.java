package dynamicProgramming.P_15990;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

n = 1 -> 1
n = 2 -> 2
n = 3 -> (1, 2), (2, 1)
n = 4 -> (1, 2, 1), (1, 3), (3, 1)
n = 5 -> (1, 3, 1), (2, 3), (3, 2)
n = 6 -> (1, 2, 1, 2), (2, 1, 2, 1), (2, 3, 1), (1, 2, 3), (3, 2, 1), (1, 3, 2)
n = 7 -> (1, 2, 1, 2, 1), (1, 2, 3, 1), (1, 3, 1, 2), (2, 3, 2), (1, 2, 1, 3), (3, 1, 3) ...

dp[n]을 n을 만드는 방법의 수라고 할 때, dp[n]은 dp[n-3], dp[n-2], dp[n-1] 에 각각 3, 2, 1을 더하는 방법의 수이다. 하지만, 같은 수를 연속으로 더할 수 없다는 규칙 때문에 1차원 배열 만으로는 규칙성 있게 표현할 수 없다.
dp[i][j] 에서 i는 표현하려고 하는 수 n, j는 이 수를 표현하는 방법의 마지막 수를 나타내도록 한다.
dp[4][1] : (1, 2, 1), (3, 1)
dp[4][2] :
dp[4][3] : (1, 3)

dp[5][1]은 dp[4][1]에 1을 더하는 방식으로 구할 수 없으므로 dp[5][1] = dp[4][2] + dp[4][3]
dp[5][2] = dp[3][1] + dp[3][3], dp[5][3] = dp[2][1] + dp[2][2] 로 표현한다.

점화식
dp[n][1] = (dp[n-1][2] + dp[n-1][3]) % 1000000009
dp[n][2] = (dp[n-2][1] + dp[n-2][3]) % 1000000009
dp[n][3] = (dp[n-3][1] + dp[n-3][1]) % 1000000009


 */
public class Main {

    private void printdp(int[] arr) {
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        // 미리 테스트 케이스의 가능한 전 범위의 값을 구한 후
        for (int j = 0; j < arr.length; j++) {
            for (int i = 4; i <= arr[j]; i++) {
                dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
                dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
                dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
            }
        }

        // 케이스 별로 각각 호출
        for (int i =0; i < arr.length; i ++) {
            long res = (dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % 1000000009;
            System.out.println(res);
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 배열에 담지 않고 그냥 반복문으로 실행하면 시간초과
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        printdp(arr);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
