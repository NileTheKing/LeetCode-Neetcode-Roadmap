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
    int idx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder로는 root
        //inorder로는 left subtree, rightsubtree알 수 있음
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1);
    }
    public TreeNode build(int[] preorder, int[] inorder, int l, int r) {
        if (r < l) return null;

        int rootVal = preorder[idx++];
        int rootIdx = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, inorder, l, rootIdx - 1);
        root.right = build(preorder, inorder, rootIdx + 1, r);

        return root;

    }
}