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
    Map <Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, inorder.length -1);   
    }
    public TreeNode dfs(int[] preorder, int[] inorder, int l, int r) {
        
        if (l > r) return null;
        int rootVal = preorder[preIdx++];
        int rootIdx = map.get(rootVal);

        TreeNode node = new TreeNode(rootVal);
        node.left = dfs(preorder, inorder, l, rootIdx-1);
        node.right = dfs(preorder, inorder, rootIdx+1, r);

        return node;
    }

}
/**
recursively construct the tree.     
how?
    => what preoreder tells is is that the first node of the array is the root of the tree.
    and what inorder array tells us is the left subtree of the root and also the right.
    so if you can recursively iterate those arrays and traverse the tree, you can build a complete tree
    say you start with 3 becuz first node of preorder is 3. then according to inorder array, you know the left part is 9, the right part is 3,15,20,7
    then you look for the elements that come before the root of the inorder array, which is 9. then you recursively construct the subtree for the root 9.
    the left subtree is empty, right subtree of 9 is empty becuz there is nothing between 3 and 9 according to inrorder array.
    Back to the 3, original root, its right subtree would be 3,15,20,7. and its root is 20 according to preorder.
    the left part of 20 would be 15 and for the right it would be 7. that's pretty much it. 

    So get into the code. we need a dfs function that comes with left parameter, right parameter for the inorder array to construct the subtrees. 

 */