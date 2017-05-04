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
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */

    /*
        需要使用2个全局变量记录当前最小树的root已经已经出现的最小sum值，
        自底向上计算每个子树的sum，更新2个变量
    */
    TreeNode minNode = null;
    int minSum = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        helper(root);
        return minNode;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = root.val + helper(root.left) + helper(root.right);
        if(sum < minSum){
            minSum = sum;
            minNode = root;
        }
        return sum;
    }
}