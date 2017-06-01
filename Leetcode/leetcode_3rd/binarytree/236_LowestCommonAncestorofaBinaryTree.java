/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Not a BST, so we have to search in the tree for 2 node
postorder search for q and p, 
-left != null && right != null : q and p are in the different subtree, return current root in the recursion call
-left != null && right == null : q and p are all in the left subtree, return left in the recursion call
-left == null && right != null : q and p are all in the right subtree, return right the recursion call
*/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        return right;
    }
}