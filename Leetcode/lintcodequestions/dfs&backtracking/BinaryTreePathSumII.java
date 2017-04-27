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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root, target);
        return result;
    }
    
    private void helper(List<List<Integer>> result, TreeNode root, int remain){
        if(root == null){
            return;
        }
        search(result, new ArrayList<Integer>(), root, remain);
        helper(result, root.left, remain);
        helper(result, root.right, remain);
    }
    
    private void search(List<List<Integer>> result, List<Integer> list, TreeNode root, int remain){
        if(root == null){
            return;
        }
        
        list.add(root.val);
        if(remain == root.val){
            result.add(new ArrayList<Integer>(list));//这个地方不能返回，下面的path中可能还有解
        }
        search(result, list, root.left, remain - root.val);
        search(result, list, root.right, remain - root.val);
        //递归结束，回溯删除list最后的元素
        list.remove(list.size() - 1);
    }
}