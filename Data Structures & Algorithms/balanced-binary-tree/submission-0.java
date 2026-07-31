/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int val = recur(root);
        if (val == -1) return false;
        return true;
    }

    int recur(TreeNode root) {
        if (root == null) return 0;

        int leftVal = recur(root.left);
        int rightVal = recur(root.right);
        if (leftVal == -1 || rightVal == -1 || Math.abs(leftVal - rightVal) > 1) return -1;

        return 1 + Math.max(leftVal, rightVal);
    }
}
