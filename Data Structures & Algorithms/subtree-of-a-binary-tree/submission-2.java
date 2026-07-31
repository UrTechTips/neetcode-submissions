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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                return sameTree(root, subRoot) || (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
            } else {
                return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
            }
        } else {
            return false;
        }
    }

    boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root != null && subRoot != null) {
            if (root.val == subRoot.val) {
                return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
