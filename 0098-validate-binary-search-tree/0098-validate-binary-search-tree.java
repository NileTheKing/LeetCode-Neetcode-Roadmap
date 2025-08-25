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

        return dfs(root, null, null);
    }
    public boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        
        // int tmp_min = min == null ? Integer.MAX_VALUE : min;
        // int tmp_max = max == null ? Integer.MIN_VALUE : max;

        // if (node.val < tmp_min && node.val > tmp_max) {
        //     return dfs(node.left, node.val, max) && dfs(node.right, min, node.val);
        // }
        // else return false;
        if (min != null && node.val >= min) return false;
        if (max != null && node.val <= max) return false;

        return dfs(node.left, node.val, max) && dfs(node.right, min, node.val);


        


    }
}
/**\
dfs로 순회하면서 검증해야해
bst의 정의에 따라 최소와 최댓값을 가지고 다니면서 어긋나면 return false

 */