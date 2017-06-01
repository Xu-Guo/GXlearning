/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        
        root.left = null;
        root.right = left;
        TreeNode node = root;
        while(node.right != null){
            node = node.right;
        }
        node.right = right;
    }
}