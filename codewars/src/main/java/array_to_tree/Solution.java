package array_to_tree;


import java.util.LinkedList;
import java.util.Queue;


class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value) {
        this(value, null, null);
    }
}



public class Solution {

    static TreeNode arrayToTree(int[] array)
    {
        if (array == null || array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        if (array.length == 1) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 0;
        while (!queue.isEmpty()) {
            TreeNode newRoot = queue.poll();
            if (newRoot.left == null && i + 1 < array.length) {
                newRoot.left = new TreeNode(array[++i]);
                queue.add(newRoot.left);

            }
            if (newRoot.right == null && i + 1< array.length) {
                newRoot.right = new TreeNode(array[++i]);
                queue.add(newRoot.right);

            }
            if (i >= array.length - 1) {
                break;
            }
        }

        return root;
    }


    public static void main(String[] args) {
        int[] array = { 3, 0, 15, 17, -4};
        new Solution().arrayToTree(array);
    }
}
