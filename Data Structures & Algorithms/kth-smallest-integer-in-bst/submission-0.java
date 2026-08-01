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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new LinkedList<>();
        recur(root, res);
        return res.get(k-1);
    }

    void recur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        recur(root.left, res);
        res.add(root.val);
        recur(root.right, res);
    }
}
