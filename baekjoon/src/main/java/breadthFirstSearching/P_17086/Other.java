package breadthFirstSearching.P_17086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Other {
    static int arr[][];
    static boolean check[][];
    static int n, m;
    static int dx[]= {0,0,1,-1,1,1,-1,-1};
    static int dy[]= {1,-1,0,0,1,-1,-1,1};

    static int bfs(int a, int b) {
        check = new boolean[n+1][m+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b, 0});
        check[a][b] = true;

        while(!q.isEmpty()) {
            int v[] = q.poll();

            for (int i=0; i < 8; i++) {
                int x = v[0] + dx[i];
                int y = v[1] + dy[i];
                int z = v[2] + 1;

                if (x < 0 || x >= n || y < 0 || y >= m || check[x][y] == true) {
                    continue;
                }
                if (arr[x][y] == 1) {
                    return z;
                }
                q.add(new int[]{x, y, z});
                check[x][y] = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int num = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(arr[i][j] != 1) {
                    num = bfs(i,j);
                    cnt = Math.max(num, cnt);
                }
            }
        }
        System.out.println(cnt);
    }
}
