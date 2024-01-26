package practiceTest.validParentheses;

import java.util.*;

/*
채점 결과
정확성: 46.3
효율성: 0.0
합계: 46.3 / 100.0

----

효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)

----

정확성  테스트
테스트 1 〉	통과 (0.02ms, 73.1MB)
테스트 2 〉	통과 (0.03ms, 71.9MB)
테스트 3 〉	통과 (0.02ms, 71.5MB)
테스트 4 〉	통과 (0.02ms, 71.1MB)
테스트 5 〉	통과 (0.19ms, 74MB)
테스트 6 〉	통과 (0.02ms, 76.2MB)
테스트 7 〉	통과 (0.18ms, 75.5MB)
테스트 8 〉	통과 (0.21ms, 84.9MB)
테스트 9 〉	실패 (0.33ms, 83.3MB)
테스트 10 〉	실패 (0.22ms, 72.6MB)
테스트 11 〉	통과 (0.21ms, 71.2MB)
테스트 12 〉	실패 (0.71ms, 72.5MB)
테스트 13 〉	실패 (0.52ms, 83MB)
테스트 14 〉	실패 (0.40ms, 73.5MB)
테스트 15 〉	실패 (0.39ms, 77MB)
테스트 16 〉	통과 (0.73ms, 75.1MB)
테스트 17 〉	통과 (0.04ms, 72.3MB)
테스트 18 〉	통과 (0.03ms, 78.7MB)

범위 계산을 잘 못해서 근본적이고 간단한 아이디어에서 멀어짐
정확성 테스트는 왜 실패했는지 모르겠음.

 */

class Solution {

    private List<Integer> cntList = new LinkedList<>();
    private List<Integer> countRegister(List<Character> charList, List<Integer> cntList) {

        List<Integer> cnt_register = cntList;
        Integer cnt = 0;

        for (int i = 0; i < charList.size(); i++) {
            if (charList.get(0) == charList.get(i)) {
                cnt++;

            } else {
                charList.subList(0, i).clear();
                cnt_register.add(cnt);
                return countRegister(new ArrayList<>(charList), cntList);
            }
        }

        cnt_register.add(cnt);
        return cnt_register;
    }

    private boolean checkCount(List<Integer> cnt_register) {

        boolean validCount=true;

        if (cnt_register.size() % 2 !=0) {
            validCount=false;
            return validCount;
        }
        for (int i = 0; i < cnt_register.size()-1; i=i+2) {
            if ((cnt_register.get(i)).equals(cnt_register.get(i + 1))) {

            } else {

                validCount = false;
                return validCount;
            }
        }

        return validCount;
    }


    boolean solution(String s) {
        boolean valid = true;

        if (s.length() % 2 != 0) {
            valid = false;
            return valid;

        }

        char[] chars = s.toCharArray();
        if ((chars[0] == ')') || (chars[s.length()-1]=='(')) {
            valid = false;
            return valid;
        }


        List<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }

        List<Integer> toInput = countRegister(charList, cntList);
        return checkCount(toInput);
    }
    public static void main(String[] args) {
        new Solution().solution("()()");
    }
}