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

/*  1.首先判断A,B是否在树中，如果有1个不在树中返回null
	2.后续遍历树，如果
*/
public class Solution {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null || root == A || root == B){
            return root;
        }
        if (contains(root, A) && contains(root, B)){
            return helper(root, A, B);
        }
        return null;
    }
    
    private boolean contains(TreeNode root, TreeNode target){
        if(root == null){
            return false;
        }
        if(root == target){
            return true;
        }
        return contains(root.left, target) || contains(root.right, target);
    }
    
    private TreeNode helper(TreeNode root, TreeNode a, TreeNode b){
        if(root == null || root == a || root == b){
            return root;
        }
        TreeNode left = helper(root.left, a, b);
        TreeNode right = helper(root.right, a ,b);
        if(left != null && right != null){
            return root;
        }
        if(left == null){
            return right;
        }else{
            return left;
        }
    }
}