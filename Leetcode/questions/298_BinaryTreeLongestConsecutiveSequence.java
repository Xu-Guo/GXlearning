public class 298_BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(helper(root.left, 1, root.val), helper(root.right, 1, root.val));
    }
    
    private int helper(TreeNode root, int count, int val){
        if(root==null){
            return count;
        }
        if(root.val - val == 1){
            count++;
        }else{
            count=1;
        }
        int left = helper(root.left, count, root.val);
        int right = helper(root.right, count, root.val);
        return Math.max(Math.max(left, right),count);
    }
}