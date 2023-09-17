package algorithmLesson.quickSort.P_24090;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int K;
    private int cnt;
    private String result = "-1";

    private void quickSort(int[] arr, int start, int end) {
        if (cnt > K) {
            return;
        }

        if (start < end) {
            int std = partition(arr, start, end);
            quickSort(arr, start, std - 1);
            quickSort(arr, std + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int x = arr[end];
        int i = start - 1;

        for (int j = start; j <= end-1; j++) {
            if(arr[j] <= x) {
                int tmp = arr[++i];
                arr[i] = arr[j];
                arr[j] = tmp;

                cnt++;
                if (cnt == K) {
                    result = arr[i]+" "+arr[j];
                }
            }
        }

        if (i + 1 != end) {
            int tmp = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = tmp;

            cnt++;
            if (cnt == K) {
                result = arr[i+1]+" "+arr[end];
            }
        }

        return i + 1;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int [N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        quickSort(arr, 0, N-1);

        bw.write(result);
        bw.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
