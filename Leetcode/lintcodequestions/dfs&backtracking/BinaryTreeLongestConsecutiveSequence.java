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
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }
        helper(root, 1);
        return max;
    }
    
    private void helper(TreeNode root, int curLen){
        max = Math.max(max, curLen);
        if(root.left != null){
            if(root.left.val == root.val + 1){
                helper(root.left, curLen + 1);
            }else{
                helper(root.left, 1);
            }
        }
        if(root.right != null){
            if(root.right.val == root.val + 1){
                helper(root.right, curLen + 1);
            }else{
                helper(root.right, 1);
            }
        }
        
    }
}