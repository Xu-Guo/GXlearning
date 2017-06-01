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
For each node in the tree, we need to find the max path sum to its left and max path to its right,
update the final max if needed

The recursive method findMaxDown returns the max path down on a node

*/
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxDown(root);
        return max;
    }
    
    private int findMaxDown(TreeNode root){
        if (root == null){
            return 0;
        }

        //get max path sum from left subtree and right subtree, if <0, set to 0
        int left = Math.max(0, findMaxDown(root.left));
        int right = Math.max(0, findMaxDown(root.right));
        
        //update max
        max = Math.max(max, left + right + root.val);

        //return max path down on current node
        return Math.max(left, right) + root.val;
    }
}