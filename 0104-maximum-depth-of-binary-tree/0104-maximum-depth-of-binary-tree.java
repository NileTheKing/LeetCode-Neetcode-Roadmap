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
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }
    public void dfs(TreeNode node, int level) {
        if (node == null) return;
        max = Math.max(level, max);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        return;
    }
}