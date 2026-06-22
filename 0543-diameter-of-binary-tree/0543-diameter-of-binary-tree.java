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
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
    // public int getDepth(TreeNode node) {
    //     if (node == null) return 0;
    //     return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    // }
}
/**
헷갈리는지점
단순 최대깊이 추적은 재귀로 1 + 재귀함수
근데 이문제는 깊이를 추적하긴함 근데 문제는..,,
일단 재귀딸깍 절대하지말고 나눠서해 하나로 노
 */