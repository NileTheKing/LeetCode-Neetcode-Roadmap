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
    Map<Integer, Integer> indices = new HashMap<>();
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }
        return construct(preorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode construct(int[] preorder, int[] inorder, int l, int r) {
        if(l > r) return null;
        int root_val = preorder[preIdx++];
        int rootIdx = indices.get(root_val); //이제 inorder에서의 루트의 인덱스를 앎
        TreeNode node = new TreeNode(root_val);
        node.left = construct(preorder, inorder, l, rootIdx - 1);
        node.right = construct(preorder, inorder, rootIdx + 1, r);

        return node;
    }
}
/**
트리는 재귀적인 특성을 가질 수 있음을 인지
preordrer: 자기 먼저 방문. 일단 루트 알 수 있음.
inorder: 얘는 왼쪽 서브트리와 오른쪽 서브트리의 사이즈를 알 수 있음 -> 이것이 무엇을 의미하나?
 */