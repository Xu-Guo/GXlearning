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
-check the current tree rooted at root, if it is a BST, return countNode(root);
    else return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right))

*/
public class Solution {
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (isValid(root)){
            return countNode(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        
    }
    
    private boolean isValid(TreeNode root){
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (pre != null && node.val <= pre.val){
                return false;
            }
            pre = node;
            cur = node.right;
        }
        return true;
    }
    
    private int countNode(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }
}