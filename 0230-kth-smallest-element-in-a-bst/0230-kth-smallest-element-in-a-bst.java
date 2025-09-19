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
    int[] info = new int[2];
    info[0]= k;
    dfs(root, info);
    return info[1];

    }
    public void dfs(TreeNode node, int[] info) { //info[0] = cnt, info[1] answer
        if (node == null) return;
        dfs(node.left, info); //preorder
        info[0]--;
        if (info[0] == 0) {
            info[1] = node.val;
            return;
        }
        dfs(node.right, info);
    }
}
/**
idae: preorder traversal of bst.
the order = ascending order visiting sequence
 */