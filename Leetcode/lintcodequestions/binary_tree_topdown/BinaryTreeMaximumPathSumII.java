/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree.
     * @return an integer
     */
    int max = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null){
            return 0;
        }
        helper(root, root.val);
        return max;
    }
    
    private void helper(TreeNode root, int cur){
        if(root == null){
            return;
        }
        if(cur > max){
            max = cur;
        }
        if(root.left != null){
            helper(root.left, cur + root.left.val);
        }
        
        if(root.right != null){
            helper(root.right, cur + root.right.val);
        }
    }
}