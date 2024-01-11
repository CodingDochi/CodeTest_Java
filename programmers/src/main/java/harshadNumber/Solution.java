package harshadNumber;

class Solution {
    public boolean solution(int x) {

        String input = String.valueOf(x);
        char[] chars = input.toCharArray();

        int sum = 0;
        for (char c : chars) {
            int i = Character.getNumericValue(c);
            sum = sum + i;
        }

        boolean answer;

        if (x % sum == 0) {
            answer = true;
        }
        else {
            answer = false;
        }

        return answer;

    }
    public static void main(String[] args) {
        new Solution().solution(10);
    }

}
