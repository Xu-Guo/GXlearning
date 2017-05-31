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
inorder traversal if the current node.val <= pre.val we find a wrong node,
-The first wrong node is the pre-node of the first smaller node than pre
-The second wrong node is the current node that has smaller val than its pre-node
-Swap their value then return
*/
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(pre != null && node.val < pre.val){
                if (first == null){
                    first = pre;
                }
                if (first != null){
                    second = node;
                }
            }
            pre = node;
            cur = node.right;
        }
        int val = second.val;
        second.val = first.val;
        first.val = val;
    }
}