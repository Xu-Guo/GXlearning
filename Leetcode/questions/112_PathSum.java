public class 112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int remain){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && remain-root.val == 0){
            return true;
        }
        return helper(root.left, remain-root.val) || helper(root.right, remain-root.val);
    }
}