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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);    
    }
    public boolean validate(TreeNode node, Integer max, Integer min) {
        if (node == null) return true;
        
        if (max != null && node.val <= max) return false;
        if (min != null && node.val >= min) return false;

        
        return validate(node.left, max, node.val) && validate(node.right, node.val, min);
    }
}
/**
A left subtree of a node should be stricly less than the node's val
and right side..

 */