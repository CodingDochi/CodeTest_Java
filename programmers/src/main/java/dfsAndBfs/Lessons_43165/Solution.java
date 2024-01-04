package dfsAndBfs.Lessons_43165;

class Solution {
    int cnt;
    private void dfs(int[] numbers, int target, int start, int depth) {
        if (depth == numbers.length) {
            if (start == target) {
                cnt++;
                System.out.println(cnt);
            }
            return;
        } else {
            int start_plus = start + numbers[depth];
            dfs(numbers, target, start_plus, depth+1);
            int start_minus = start - numbers[depth];
            dfs(numbers, target, start_minus, depth+1);
        }
    }
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return cnt;
    }
    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        new Solution().solution(numbers, target);
    }

}