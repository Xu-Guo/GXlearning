//simple backtrack DFS
public class 113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int remain){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && remain-root.val == 0){
            res.add(new ArrayList<Integer>(list));
        }
        helper(res, list, root.left, remain-root.val);
        helper(res, list, root.right, remain-root.val);
        list.remove(list.size()-1);
    }
}