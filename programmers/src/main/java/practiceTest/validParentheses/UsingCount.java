package practiceTest.validParentheses;

class UsingCount {
    boolean solution(String s) {
        if (s.length() % 2 != 0) return false; // 문자열의 길이가 홀수이면 유효하지 않음

        int openCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++; // 열린 괄호일 경우 카운트 증가
            } else {
                openCount--; // 닫힌 괄호일 경우 카운트 감소
                if (openCount < 0) return false; // 닫힌 괄호가 더 많으면 유효하지 않음
            }
        }

        return openCount == 0; // 열린 괄호와 닫힌 괄호의 개수가 같으면 유효한 괄호 문자열
    }
}