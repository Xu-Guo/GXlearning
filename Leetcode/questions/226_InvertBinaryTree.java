/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}