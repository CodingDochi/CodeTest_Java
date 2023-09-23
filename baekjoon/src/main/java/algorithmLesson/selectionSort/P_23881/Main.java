package algorithmLesson.selectionSort.P_23881;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static void selectionSort(int[] arr, int N, int K) {

        int cnt = 0; // 실제 교환 횟수

        for (int i = 1; i <= N - 1; i++) {

            int max_idx = 0; // 최대값 인덱스 초기 값
            int max_val = Integer.MIN_VALUE; // 최대값 초기 값

            int current = N - i; // 기준점 인덱스
            // 최대값 찾는 범위 : 0 ~ current
            for (int start = 0; start <= current; start++) {
                if (arr[start] > max_val) {
                    max_val = arr[start];
                    max_idx = start;
                }
            }

            if (max_val != arr[current]) {
                int tmp = arr[max_idx];
                arr[max_idx] = arr[current];
                arr[current] = tmp;
                cnt = cnt + 1;

                if (cnt == K) {
                    System.out.println(arr[max_idx] + " " + arr[current]);
                    return;
                }
            }
        }

        if (cnt < K) {
            System.out.println(-1);
        }

    }

    public static void main(String[] args) throws Exception {

        // 백준에서 입력은 BufferedReader, 분해는 StringTokenizer 활용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기 N, 교환 횟수 K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 크기가 N인 배열 준비
        int[] arr = new int[N];

        // 배열에 입력 옮기기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        selectionSort(arr, N, K);

    }
}
