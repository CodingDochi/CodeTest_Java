package stackQueue.Lessons_42583;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int weight_on_bridge = 0;  // 다리 위에 있는 트럭의 총 무게

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);  // 처음에 다리 길이만큼 0을 넣어 다리 상태를 초기화
        }

        for (int truckWeight : truck_weights) {
            while (true) {
                // 시간 경과
                time++;

                // 다리에서 트럭이 빠져나감
                weight_on_bridge -= bridge.poll();

                // 다음 트럭을 다리에 올릴 수 있는지 확인
                if (weight_on_bridge + truckWeight <= weight) {
                    // 트럭을 다리에 올림
                    bridge.offer(truckWeight);
                    weight_on_bridge += truckWeight;

                    break;  // 트럭을 성공적으로 올렸으므로 루프를 종료하고 다음 트럭으로 이동
                } else {
                    // 트럭을 올리지 못하면 0을 넣어 시간만 경과
                    bridge.offer(0);
                }
            }
        }

        // 마지막 트럭이 다리를 완전히 건너는 시간을 더함
        time += bridge_length;

        return time;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = new int[]{10,10,10,10,10,10,10,10,10,10};

        int result = new Solution().solution(bridge_length, weight, truck_weights);
        System.out.println("Total time: " + result);
    }
}
