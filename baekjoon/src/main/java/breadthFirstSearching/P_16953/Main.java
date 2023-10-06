package breadthFirstSearching.P_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private long calc_count(long A, long B) {
        long count = 0;
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            long size = queue.size();

            for (int i = 0; i < size; i++) {
                long input = queue.poll();
                if (input == B) {
                    return count + 1;
                }
                if (input > B) {
                    break;
                }

                if (input * 10 + 1 <= B) {
                    long new_input = input * 10 + 1;
                    if (!queue.contains(new_input)) {
                        queue.add(new_input);
                    }
                }
                if (input * 2 <= B) {
                    long new_input = input * 2;
                    if (!queue.contains(new_input)) {
                        queue.add(new_input);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long res = calc_count(A, B);
        System.out.println(res);
    }
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}