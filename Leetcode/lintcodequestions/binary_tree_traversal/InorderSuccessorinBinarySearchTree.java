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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null || p == null){
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if(pre == p){
                return node;
            }
            pre = node;
            cur = node.right;
        }
        return null;
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode suc = null;
        while(root != null && root.val != p.val){
            if(root.val > p.val){
                suc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if(root == null){//没找到 p
            return null;
        }
        if(root.right == null){//找到 p，且p的parent没有右子树，return parent
            return suc;
        }
        
        root = root.right;//p的parent有右子树，返回其最左节点
        while(root.left != null){
            root = root.left;
        }
        
        return root;
    }
}