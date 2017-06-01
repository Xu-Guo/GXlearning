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
An O(n) solution is return 1 + countNodes(root.left) + countNodes(root.right) if root is not null
we can optimize it by looking at the left height and right height, 
-if they are equal: than the result will be 2^(height) - 1,
-Othervise we calculate the each and return the sum + 1
-since there alway one the two subtree is a full tree, we end up with O(log(n)^2)
*/
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int h = 0;
        while (right != null){
            left = left.left;
            right = right.right;
            h++;
        }
        if (left == null){
            return (1 << h) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}