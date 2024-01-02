package dfsAndBfs.Lessons_43163;

import java.util.ArrayList;
import java.util.List;

class Other {

    boolean[] visited;
    int answer = 0;

    public int solution(String begin, String target, String[] words) {

        dfs(begin, target, words, 0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int same_spell = 0; // 같은 스펠링 세기
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    same_spell++;
                }
            }
            // 한글자 빼고 모두 같은 경우
            if (same_spell == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
