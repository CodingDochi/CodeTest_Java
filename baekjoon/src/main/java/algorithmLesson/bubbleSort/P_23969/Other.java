package algorithmLesson.bubbleSort.P_23969;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Other {

    static void bubbleSort(int[] arr, int N, int K) {

        int cnt = 0; // 실제 교환 횟수

        for (int i = 0; i < N-1; i ++) {

            for (int j = 0;  j < N-1-i; j++) {

                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                    cnt = cnt + 1;
                    if (cnt == K) {
                        StringBuilder sb = new StringBuilder();
                        for (int elem : arr) {
                            sb.append(elem).append(" ");
                        }
                        System.out.println(sb);
//                        Arrays.stream(arr)
//                                .forEach(elem -> System.out.print(elem + " "));
                        return;
                    }
                }
            }
        }

        if (cnt < K) {
            System.out.println(-1);
        }
    }

    static void solution() throws Exception {

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
        for (int i =0 ; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bubbleSort(arr, N, K);
    }

    public static void main(String[] args) throws Exception {
        new Other().solution();
    }

}
