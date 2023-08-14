package algorithmLesson.bubbleSort.P_23968;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void bubbleSort(int[] arr, int N, int K) {

        int cnt = 0; // 실제 교환 횟수

        for (int last = N; last >= 2; last--) {

            for (int i = 1;  i <= last -1; i++) {

                if (arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;

//                    System.out.println(Arrays.toString(arr));
//                    [0, 4, 1, 3, 2, 5, 6]
//                    [0, 1, 4, 3, 2, 5, 6]
//                    예제 함정 있음.

                    cnt = cnt + 1;
                    if (cnt == K) {
                        System.out.println(arr[i]+" "+arr[i+1]);
                        return;
                    }
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

        // 크기가 N+1인 배열 준비
        int[] arr = new int[N+1];

        // 배열에 입력 옮기기
        st = new StringTokenizer(br.readLine());
        for (int i =1 ; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bubbleSort(arr, N, K);
    }
}
