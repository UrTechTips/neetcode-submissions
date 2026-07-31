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
    TreeNode lowest = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        recur(root, p, q);
        return lowest;
    }

    void recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return;

        if ((contains(root.left, p) || contains(root.right, p)) && (contains(root.left, q) || contains(root.right, q))) {
            lowest = root;
        }

        if (root == p) {
            if (contains(root.left, q) || contains(root.right, q)) {
                lowest = p;
            }
        }
        if (root == q) {
            if (contains(root.left, p) || contains(root.right, p)) {
                lowest = q;
            }
        }

        recur(root.left, p, q);
        recur(root.right, p, q);
    }

    boolean contains(TreeNode root, TreeNode q) {
        if (root == null) return false;
        if (root == q) return true;
        return contains(root.left, q) || contains(root.right, q);
    }
}
