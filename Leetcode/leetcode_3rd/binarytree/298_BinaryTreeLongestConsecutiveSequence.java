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
Typical DFS 
Dont forget check if the node is null before call node.val!!!
*/
public class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null){
            return max;
        }
        helper(root, 1);
        return max;
    }
    
    private void helper(TreeNode root, int curLen){
        max = Math.max(max, curLen);
        if (root == null){
            return;
        }
        if (root.left != null && root.left.val - root.val == 1){
            helper(root.left, curLen + 1);
        } else {
            helper(root.left, 1);
        }
        if (root.right != null && root.right.val - root.val == 1){
            helper(root.right, curLen + 1);
        } else {
            helper(root.right, 1);
        }
    }
}