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
    List<Integer> order = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return order.get(k-1);
    }
    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        order.add(node.val);
        dfs(node.right);
        return;
    }
}
/**
bst의 inoreder 순회는 작은거부터 방문함.
왜냐하면 inorder는 좌본우 우선순위인데
most left node 가 가장 작음.
 */