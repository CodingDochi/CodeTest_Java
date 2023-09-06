package algorithmLesson.insertionSort.P_24051;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int K;

    private StringBuilder sb = new StringBuilder();

    private void insertionSort(int[] arr) {

        // 실제 저장 횟수
        int cnt = 0;

        for (int i=1; i<N; i++) {
            int loc = i-1;
            int newItem = arr[i];

            // arr[1 ... i-1] 은 이미 정렬되어 있는 상태라고 가정
            while(0 <= loc && newItem < arr[loc]) {
                arr[loc + 1] = arr[loc];
                loc--;

                cnt = cnt + 1;
                if (cnt == K) {
                    for (int elem : arr) {
                        sb.append(elem).append(" ");
                    }
                    System.out.println(sb);
                    return;
                }
            }

            if (loc+1 != i) {
                arr[loc + 1] = newItem;

                cnt = cnt + 1;
                if (cnt == K) {
                    for (int elem : arr) {
                        sb.append(elem).append(" ");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }

        if (cnt < K) {
            System.out.println(-1);
        }
    }

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

        insertionSort(arr);

    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
