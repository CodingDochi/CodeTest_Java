package practiceTest.validParentheses;

import java.util.*;

class UsingStack {
    boolean solution(String s) {
        if (s.length() % 2 != 0) return false; // 문자열의 길이가 홀수이면 유효하지 않음

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 열린 괄호일 경우 스택에 추가
            } else {
                // 닫힌 괄호일 경우 스택이 비어있거나 최근에 추가된 열린 괄호와 매칭되지 않으면 유효하지 않음
                if (stack.isEmpty() || stack.pop() != '(') return false;
            }
        }

        return stack.isEmpty(); // 스택이 비어있으면 유효한 괄호 문자열
    }
}