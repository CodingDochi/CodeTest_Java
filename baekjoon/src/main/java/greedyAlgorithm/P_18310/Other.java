package greedyAlgorithm.P_18310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Other {

    int N;

    private int calc_index(int[] location) {

        List<Integer> candidate = new ArrayList<>();

        if (N % 2==0) {
            candidate.add(location[N / 2 - 1]);
            candidate.add(location[N / 2]);

//            System.out.println(candidate.toString());

            long min_sum = Long.MAX_VALUE;
            long sum = 0;
            int mem = 0;

            for (int i = 0; i < candidate.size(); i++) {
                for (int elem : location) {
                    sum = sum + Math.abs(candidate.get(i) - elem);
//                    System.out.println("i : "+i+"  sum : "+sum);
                }
                if (sum < min_sum) {
                    min_sum = sum;
                    mem = i;
                }
                sum = 0;
            }
            if (mem == 0) {
                return N/2 -1;
            } else {
                return N/2;
            }
        } else {
            return N/2;
        }

    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] location = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(location);

        int res = location[calc_index(location)];
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        new Other().solution();
    }


}
