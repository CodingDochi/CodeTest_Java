package algorithmLesson.matrixPath.P_24418;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Other {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            br.readLine();
        }

        int[][] cache = new int[n+1][n+1];
        for(int i=0; i<=n; i++) {
            cache[0][i] = 1;
            cache[i][0] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
            }
        }

        System.out.println(String.format("%d %d", cache[n][n], n * n));
    }
}