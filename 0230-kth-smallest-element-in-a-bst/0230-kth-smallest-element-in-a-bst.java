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
        //info[0] == current count, info[1] == ans
        int[] info = new int[2];
        info[0] = 0;
        inorder(root, info, k);
        return info[1];
    }
    public void inorder(TreeNode node, int[] info, int k) {
        if (node == null) return;
        //System.out.printf("visiting %d\n", node.val);
        //left
        inorder(node.left, info, k);
        //self
        info[0]++;
        //System.out.printf("visiting %d, count = %d\n", node.val, info[0]);
        if (info[0] == k) {
            info[1] = node.val;
            return;
        }
        //right
        inorder(node.right, info, k);
    }
}