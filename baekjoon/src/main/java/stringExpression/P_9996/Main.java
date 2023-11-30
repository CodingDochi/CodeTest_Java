package stringExpression.P_9996;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    String rule;
    List<String> argList;

    private boolean validation(String str_arg) {
        List<Character> mem = new ArrayList<>();
        for (int i = 0; i < rule.length(); i++) {
            if (rule.charAt(i) != '*') {
                mem.add(rule.charAt(i));
            }
        }

        List<Character> target = new ArrayList<>();
        for (int i = 0; i < str_arg.length(); i++) {
            if (mem.contains(str_arg.charAt(i))) {
                target.add(str_arg.charAt(i));
            }
        }

        if (target.size() < mem.size()) {
            return false;
        }
        if ((target.get(0) != mem.get(0)) || (target.get(target.size()-1) != mem.get(mem.size()-1))) {
            return false;
        }
        int i = 0;
        int j = 0;
        while(i < target.size() && j < mem.size()) {
            if (target.get(i) == mem.get(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            if (i == target.size() && j < mem.size()) {
                return false;
            }
        }
        return true;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        rule = br.readLine();
        argList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            argList.add(br.readLine());
        }

        for (String elem : argList) {
            boolean res = validation(elem);
            if (!res) {
                System.out.println("NE");
            } else {
                System.out.println("DA");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}

/*
반례

1
a*a
abab

 */