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
/*
    中序遍历！！注意不能有val相等的两个node
*/
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        TreeNode pre = null;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(pre != null && node.val <= pre.val){
                return false;
            }
            pre = node;
            cur = node.right;
        }
        return true;
    }
}