package algorithmLesson.mergeSort.P_24060;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int K;
    private int cnt = 0;
    private int[] sorted;

    private void solution() throws Exception {
        // 백준에서 입력은 BufferedReader, 분해는 StringTokenizer 활용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기 N, 저장 제한 횟수 K
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 크기가 N인 배열 만들기
        int[] arr = new int[N];

        // 배열에 입력 옮기기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sorted = new int[N];

        mergeSort(arr, 0, N-1);
        if (cnt < K) { System.out.println(-1);}

    }

    private void mergeSort(int[] arr, int start, int end) {
        // 더이상 분할 할 수 없을 때까지 재귀함수를 진행시킨 후
        // 가장 작은 단위(가장 깊은 재귀)부터 merge를 실행합니다.
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private void merge(int[]arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int t = 0;

        // 각각의 while 루프가 조건으로 참조하는 범위가 겹치는 경우,
        // 여러 while 루프가 동시에 실행되는 것이 아니라 순차적으로 실행됩니다

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[t++] = arr[i++];
            } else {
                sorted[t++] = arr[j++];
            }
        }
        // 왼쪽 배열 부분이 남은 경우
        while (i <= mid) {
            sorted[t++] = arr[i++];
        }
        // 오른쪽 배열 부분이 남은 경우
        while (j <= end) {
            sorted[t++] = arr[j++];
        }

        i = start;
        t = 0;
        // 결과를 arr[]에 저장
        while (i <= end) {
            arr[i++] = sorted[t];
            cnt = cnt + 1;
            if (cnt == K) {
                System.out.println(sorted[t]);
                return;
            }
            t++;
        }

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

/*

tmp[t++] = arr[i++] 코드는 arr[i]의 값을 tmp[t]에 할당한 후에 i와 t를 각각 1씩 증가시키는 것입니다



 */