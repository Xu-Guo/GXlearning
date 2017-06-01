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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        //need to pass in the final result and current list
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    
    private void helper (List<List<Integer>> res, List<Integer> list, TreeNode root, int remain){
        if (root == null){
            return;
        }
        
        list.add(root.val);
        
        if (root.left == null && root.right == null && root.val == remain){
            res.add(new ArrayList<>(list));
            //remove the last element from current list, important
            list.remove(list.size() - 1);
            return;
        }
        
        helper(res, list, root.left, remain - root.val);
        helper(res, list, root.right, remain - root.val);
        
        //remove the last element from current list, important
        list.remove(list.size() - 1);
    }
}