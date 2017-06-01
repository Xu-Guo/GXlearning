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
postorder traversal, if node is null, or,  both of the left subtree and right subtree are valid and 
root.val == root.left.val == root.right.val, then, this tree is valid
bottom up count the total number of valid trees.
must use int[] as arg, othervise use global var
*/
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
    private boolean helper(TreeNode root, int[] count){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        if(left && right){
            if(root.left != null && root.val != root.left.val){
                return false;
            }
            if(root.right != null && root.val != root.right.val){
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}