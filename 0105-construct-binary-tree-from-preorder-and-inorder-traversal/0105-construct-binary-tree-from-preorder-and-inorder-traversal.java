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
    int preIdx = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode construct(int[] preorder, int[] inorder, int l, int r) {
        if (l > r) return null;

        int rootVal = preorder[preIdx];
        int inorder_idx = map.get(rootVal);
        preIdx++;
        TreeNode node = new TreeNode(rootVal);
        node.left = construct(preorder, inorder, l, inorder_idx - 1);
        node.right = construct(preorder, inorder, inorder_idx + 1, r);

        return node;
    }

}