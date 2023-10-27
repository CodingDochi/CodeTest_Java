package divideAndConquer.P_4779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// Ctrl^D로 입력 중지. 평균 메모리 사용량 및 실행시간을 훨씬 초과하는 코드

public class Main {

    private List<String> divider(List<String> bar) {

        if (bar.size() == 1) {
            return bar;
        } else {
            List<String> space = new ArrayList<>();

            for (int i = 0; i < bar.size() / 3; i++) {
                space.add(" ");
            }

            List<String> front = new ArrayList<>(divider(bar.subList(0, bar.size() / 3)));
            List<String> back = new ArrayList<>(divider(bar.subList(bar.size() * 2 / 3, bar.size())));

            front.addAll(space);
            front.addAll(back);

            return front;
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> res = new ArrayList<>();
        String answer = "";
        String input;
        List<String> bar = new ArrayList<>();
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            for (int i = 0; i < Math.pow(3, N); i++) {
                bar.add("-");
            }
//            System.out.println(bar);

            answer = String.join("", divider(bar));
            res.add(answer);
            bar.clear();
        }
        for (String elem : res) {
            System.out.println(elem);
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
