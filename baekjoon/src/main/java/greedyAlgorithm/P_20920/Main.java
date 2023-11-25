package greedyAlgorithm.P_20920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    int N;
    int M;

    class WordComparator implements Comparator<String> {
        Map<String, Integer> word_mem;
        public WordComparator(Map<String, Integer> word_mem) {
            this.word_mem = word_mem;
        }

        @Override
        public int compare(String word1, String word2) {
            int freq_compare = Integer.compare(word_mem.get(word2), word_mem.get(word1));
            if ( freq_compare != 0 ) {
                return freq_compare;
            } else {
                int length_compare = Integer.compare(word2.length(), word1.length());
                if ( length_compare != 0 ) {
                    return length_compare;
                } else {
                    return word1.compareTo(word2);
                }
            }
        }
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> word_mem = new HashMap<>();

        for (int i = 0; i < N; i ++) {
            String word = br.readLine();
            if (word.length() >= M) {
                word_mem.put(word, word_mem.getOrDefault(word, 0) + 1);
            }
        }

        List<String> word_list = new ArrayList<>(word_mem.keySet());
        Collections.sort(word_list, new WordComparator(word_mem));

        // 정렬된 단어들을 출력
        StringBuilder sb = new StringBuilder();
        for (String str : word_list) {
            sb.append(str + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
