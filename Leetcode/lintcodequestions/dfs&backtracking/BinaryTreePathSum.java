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
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        helper(res, new ArrayList<Integer>(), root, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int remain){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.val == remain && root.left == null && root.right == null){
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        helper(res, list, root.left, remain - root.val);
        helper(res, list, root.right, remain - root.val);
        list.remove(list.size() - 1);
    }
}