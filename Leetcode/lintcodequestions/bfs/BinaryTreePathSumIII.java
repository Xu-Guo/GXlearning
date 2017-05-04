/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, target, result);
        return result;
    }
    
    private void dfs(ParentTreeNode root, int target, List<List<Integer>> result ){
        if(root == null){
            return;
        }
        findSum(root, null, target, new ArrayList<Integer>(), result);
        
        dfs(root.left, target, result);
        dfs(root.right, target, result);
    }
    
    private void findSum(ParentTreeNode root, ParentTreeNode father, int target, 
                    List<Integer> path, List<List<Integer>> result){
        path.add(root.val);
        target -= root.val;
        
        if(target == 0){
            result.add(new ArrayList<Integer>(path));
        }
        
        if (root.parent != null && root.parent != father)
            findSum(root.parent, root, target, path, result);

        if (root.left != null && root.left  != father)
            findSum(root.left, root, target, path, result);

        if (root.right != null && root.right != father)
            findSum(root.right, root, target, path, result);
        
        path.remove(path.size() - 1);
    }
}