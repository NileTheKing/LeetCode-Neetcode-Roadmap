/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else if (Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }else { // 왼쪽에 하나 오른쪽에 하나 or 자기자신이랑 자식..그니까 위의 케이스가 아닌 경우.
            //답
            return root;
        }
    
    }
}

/**
순회해서 찾아야함. 그런데 bst임. -> 탐색 범위 지정
    둘중 더 작은게 만약 root보다 크면 오른쪽 가야함
    둘중 더 큰 게 더 작으면 왼쪽으로 가야함.
    그게 아니라면 양쪽으로 
 */