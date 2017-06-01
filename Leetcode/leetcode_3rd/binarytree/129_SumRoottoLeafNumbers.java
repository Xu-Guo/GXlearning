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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return sum;
        }

        helper(root, root.val);
        return sum;
    }
    
    private void helper(TreeNode root, int curSum){
        if (root.left == null && root.right == null){
            sum += curSum;
            return;
        }
        if (root.left != null){
            helper(root.left, curSum * 10 + root.left.val);
        }
        if (root.right != null){
            helper(root.right, curSum * 10 + root.right.val);
        }
    }
}



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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int curSum){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return curSum * 10 + root.val;
        }
        curSum = curSum * 10 + root.val;
        return helper(root.left, curSum) + helper(root.right, curSum);
        
    }
}