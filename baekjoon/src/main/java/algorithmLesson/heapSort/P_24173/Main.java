package algorithmLesson.heapSort.P_24173;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int K;
    private int cnt;

    private String result = "-1";

    private void heapSort(int[] arr) {
        if(cnt > K){ return; }
        build_min_heap(arr, N);
        for (int i = N; i >= 2; i--) {
            int tmp = arr[1];
            arr[1] = arr[i];
            arr[i] = tmp;
            cnt++;
            if (cnt == K) {
                result =  arr[i]+" "+arr[1];
                return;
            }
            heapify(arr, 1, i-1);

        }

    }

    // ⌊x⌋=largest integer≤x
    // range_limit은 배열 arr의 인덱스를 1부터 셀 때의 최대 인덱스를 나타낸다. range_limit의 최대값 = N
    private void build_min_heap(int[] arr, int range_limit) {
        for (int i = range_limit/2; i>=1; i--) {
            heapify(arr, i, range_limit);
//            System.out.println(Arrays.toString(arr));
        }
    }

    // arr[std]를 루트로 하는 트리를 최소 힙 성질을 만족하도록 수정한다.
    // 가장 작은 것이 배열의 오른쪽 끝으로 이동
    // arr[std]의 두 자식을 루트로 하는 서브 트리는 최소 힙 성질을 만족하고 있다.

    private void heapify(int[] arr, int std, int range_limit) {
//        System.out.println(Arrays.toString(arr));
        int left = 2*std;
        int right = 2*std + 1;
        int smaller;
        if (right <= range_limit) {
            if (arr[left] < arr[right]) {
                smaller = left;
            }
            else {
                smaller = right;
            }
        }
        else if (left <= range_limit) {
            smaller = left;
        }
        else return;

        // 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다
        if (arr[smaller] < arr[std]) {
            int tmp = arr[std];
            arr[std] = arr[smaller];
            arr[smaller] = tmp;
            cnt++;
            if(cnt==K){
                result = arr[std]+" "+arr[smaller];
                return;
            }
            heapify(arr, smaller, range_limit);
        }

//        System.out.println(Arrays.toString(arr));
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(arr);
        bw.write(result);
        bw.flush();
    }
    public static void main(String[] args) throws Exception {
            new Main().solution();
    }

}
