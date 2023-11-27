package priorityQueue.P_2696;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Other {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private void cases() throws Exception {
        int case_num = Integer.parseInt(br.readLine());
        for (int i=0; i < case_num; i++) {
            solution();
        }
    }
    private void solution() throws Exception {
        int seq_num = Integer.parseInt(br.readLine());
        List<Integer> seq = new ArrayList<>();

        int br_cnt;
        if (seq_num % 10 != 0) {
            br_cnt = seq_num/10 + 1;
        } else {
            br_cnt = seq_num/10;
        }

        for (int i = 0; i < br_cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                if (st.hasMoreTokens()) {
                    int elem = Integer.parseInt(st.nextToken());
                    seq.add(elem);
                } else {
                    break;
                }
            }
        }
        mid_between_min_max(seq_num, seq);
    }
    /*

    중앙값 : 정렬된 수열이 홀수 개의 원소로 이루어졌다면 가운데, 짝수 개의 원소로 이루어졌다면 가운데 두 수의 평균

    중앙 값의 왼쪽 : 현 시점 가장 큰 값이 중앙 값 => 최대 힙 이용
    중앙 값의 오른쪽 : 현 시점 가장 작은 값이 중앙 값 => 최소 힙 이용

    수열 요소들을 최대 힙(중앙 값의 왼쪽이므로)부터 차례로 최소 힙과 번갈아 가며 입력
    최소 힙이 비어있지 않으면 최대 힙의 루트값과 최소 힙의 루트 값을 서로 비교.
    최대 힙의 루트 값 > 최소 힙의 루트 값 => 최대 힙의 루트 값을 최소 힙의 루트 값과 교환
    중앙 값 출력은 인덱스가 0, 짝수일 때 최대 힙의 값.
     */
    private void mid_between_min_max (int seq_num, List<Integer> seq) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < seq_num; i++) {
            if (maxHeap.isEmpty() || seq.get(i) < maxHeap.peek()) {    maxHeap.add(seq.get(i));
            } else {
                minHeap.add(seq.get(i));
            }
            if (i % 2 == 0) {

                // if 대신 while문을 사용하면 maxHeap의 크기가 minHeap보다 여러 개 더 많은 경우에도 한 번에 여러 요소를 옮길 수 있습니다.

               while (maxHeap.size() > minHeap.size()) {
                   minHeap.add(maxHeap.poll());
               }
               while (maxHeap.size() < minHeap.size()) {
                   maxHeap.add(minHeap.poll());
               }
               sb.append(maxHeap.peek()).append(" ");
               cnt++;
               if (cnt == 10) {
                    sb.append("\n");
                    cnt = 0;
               }
            }
        }

        System.out.println(seq_num/2 + 1);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Other().cases();
    }

}
