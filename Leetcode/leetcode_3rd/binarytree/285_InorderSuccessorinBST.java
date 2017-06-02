/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//O(n) solution, inorder traversal
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean found = false;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (found){
                return node;
            }
            if (node == p){
                found = true;
            }
            cur = node.right;
        }
        return null;
    }
}


//O(log(n))
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    
    TreeNode ret = null;
    while (root != null) {
        // 1. current root is smaller or equal, definitely not in this branch
        if (root.val <= p.val) {
            root = root.right;
        // 2. current root is bigger, definitely in this branch             
        } else {
            // 2.1 root is 1 of the successors, although might not be the one
            ret = root;
            // 2.2 maybe we can find a closer successor in the left branch
            root = root.left;
        }
    }
    return ret;
}