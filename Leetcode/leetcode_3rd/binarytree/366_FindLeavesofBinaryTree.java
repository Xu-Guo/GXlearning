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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    //return height
    private int helper(TreeNode root, List<List<Integer>> res){
        if (root == null){
            return -1;
        }
        
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        
        int height = 1 + Math.max(left, right);
        if (res.size() == height){
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }
}