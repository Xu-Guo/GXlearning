/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 257_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root != null){
            helper(res, root, "");
        }
        return res;
    }
    
    private void helper(List<String> res, TreeNode root, String path){
        if(root.left == null && root.right == null){
            res.add(path + root.val);
        }
        if(root.left != null){
            helper(res, root.left, path + root.val + "->");
        }
        if(root.right !=null){
            helper(res, root.right, path + root.val + "->");
        }
    }
}