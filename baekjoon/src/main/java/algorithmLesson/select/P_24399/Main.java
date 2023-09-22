package algorithmLesson.select.P_24399;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private StringBuilder sb = new StringBuilder();

    private int change_limit;
    private int change_cnt;

    private int partition(int[] arr, int start_idx, int end_idx) {

        // 정렬이 끝나지 않은 배열의 마지막 값
        int x = arr[end_idx];

        // start_idx=1일 때, i=0이므로 0
        // 정렬이 한차례 완료되어 구간 중 가장 작은 값이 왼쪽 끝으로 이동할 때마다,
        // start_idx는 점점 우측으로 이동하므로
        // i는 크기가 x보다 작거나 같은 값의 가장 우측 값이다.
        int i = start_idx-1;

        for (int j = start_idx; j <= end_idx - 1; j++) {

            // arr[j]가 x보다 작거나 같지 않으면, j만 1 증가, i는 그대로.
            // x보다 작은 값들, 그러나 그들 사이에서의 대소 비교는 하지 않은 상태로 좌측 누적(i값 증가)
            if (arr[j] <= x) {
                int tmp = arr[++i];
                arr[i] = arr[j];
                arr[j] = tmp;
                change_cnt++;
                if (change_cnt == change_limit) {
                    for (int z=1; z<arr.length; z++) {
                        sb.append(arr[z]).append(" ");
                    }
                    System.out.println(sb);
                }
            }
        }
        // j는 enx_idx-1까지 순환하므로, x를 제외한 모든 요소가 x보다 작거나 같았다면
        // i+1 == end_idx가 성립.
        if (i+1 != end_idx) {
            // x보다 작거나 같은 값 중 가장 마지막으로 비교된 값보다 1 인덱스 뒤의 값
            // 즉, x보다 큰 값 중 가장 먼저 비교된 값
            int tmp = arr[i+1];
            arr[i+1] = arr[end_idx];
            arr[end_idx] = tmp;
            change_cnt++;
            if (change_cnt == change_limit) {
                for (int z=1; z<arr.length; z++) {
                    sb.append(arr[z]).append(" ");
                }
                System.out.println(sb);
            }
        }

        // 이번 정렬 작업의 기준 값이었던 x가 최종적으로 위치한 인덱스
        return i+1;
    }


    private int select(int[] arr, int start_idx, int end_idx, int small_qth) {
        // 구간 시작과 끝의 인덱스가 같다 : 왼쪽에서 오른쪽으로 오름차순 정렬이 끝났다.
        if (start_idx == end_idx) {
            if (change_cnt < change_limit) {
                System.out.println(-1);
            }
            // 정렬이 끝났으므로 첫번째 인덱스의 수가 최초 찾으려고 했던 전체에서 q번째로 작은 수가 된다.
            return arr[start_idx];
        }

        // 정렬이 끝나지 않았다면 구간별 분할 정렬 작업을 한다
        int t = partition(arr, start_idx, end_idx);
        // 정렬이 한 턴(한바퀴) 실행된 후
        // 해당 정렬 작업의 기준 값(마지막 인덱스의 값)이었던 x가 최종적으로 위치했던 인덱스 값에서
        // select의 인수인 start_idx를 빼고 1을 더한 인덱스
        // select 작업 시행시 내부의 partition이 수행되어 start_idx가 점점 우측으로 이동하는 점을 감안할 때,
        // small_kth는 우측에서 k번째 값이다.
        int small_kth = t - start_idx + 1;

        // 전체에서 q번째로 작은 값보다 우측 k번째 값이 크다면
        if (small_qth < small_kth) {

            // 이전에 정렬을 마쳤던 인덱스 t값에서 1을 뺀 인덱스( 어찌 됐든 인덱스 t에 위치한 값보다 작은 수들의 범위)
            // 까지의 범위에서 최종 목표값을 찾는다
            return select(arr, start_idx, t - 1, small_qth);
        }
        // 만약 우측 k번째 값의 크기가 목표 값과 같다면
        else if (small_qth == small_kth) {
            if (change_cnt < change_limit) {
                System.out.println(-1);
            }
            // 마지막 정렬 인덱스에 위치한 값(x 였던 것) 반환
            return arr[t];
        }
        // 목표 값이 우측 k 번째 값 보다 크다면,
        // 마지막 정렬 작업의 종료 지점보다 1 큰 인덱스(x보다 컸던 첫번째 값)에서부터 선택 작업 재시작
        // 단, 목표값은 이전 정렬 작업의 목표값에서 직전 정렬의 가장 우측 인덱스에 위치한 값을 차감한 값이다.
        else return select(arr, t + 1, end_idx, small_qth - small_kth);
    }


    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr_length = Integer.parseInt(st.nextToken());
        int small_qth = Integer.parseInt(st.nextToken());
        change_limit = Integer.parseInt(st.nextToken());

        int[] arr = new int[arr_length +1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= arr_length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        select(arr, 1, arr_length, small_qth);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}