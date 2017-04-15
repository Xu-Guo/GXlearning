//must use 2 recursion functions.
public class 437_PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }   
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int helper(TreeNode root, int sum){
        int res = 0;
        if(root == null){
            return res;
        }
        if(root.val == sum){
            res++;
        }
        res += helper(root.left, sum-root.val);
        res += helper(root.right, sum-root.val);
        return res;
    }
}