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
Typical dfs, check if the left child pr right child is null or not
-if both null, path + root.val than add it to result,
-if left is not null:
    path + root.val + "->", recursive call on root.left
-same to the right child
*/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        helper(root, "", res);
        return res;
    }
    
    private void helper(TreeNode root, String path, List<String> res){
        if (root.left == null && root.right == null){
            res.add(path + root.val);
        }
        if (root.left != null){
            helper(root.left, path + root.val + "->", res);
        }
        if (root.right != null){
            helper(root.right, path + root.val + "->", res);
        }
    }
}