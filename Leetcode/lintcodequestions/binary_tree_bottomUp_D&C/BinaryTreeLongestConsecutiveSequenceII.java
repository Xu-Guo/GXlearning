/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeInfo{
    public int max_length;
    public int max_down;
    public int max_up;
    public TreeInfo(int len, int down, int up){
        max_length = len;
        max_down = down;
        max_up = up;
    }
}

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        return helper(root).max_length;
    }
    
    private TreeInfo helper(TreeNode root){
        if(root == null){
            return new TreeInfo(0, 0, 0);
        }
        TreeInfo left = helper(root.left);
        TreeInfo right = helper(root.right);
        
        int up = 0;
        int down = 0;
        //需要保留每个点可以左右2个方向递增/递减的长度以及连续序列的总长度
        if(root.left != null && root.left.val + 1 == root.val){
            down = Math.max(down, left.max_down + 1);
        }
        if(root.left != null && root.left.val - 1 == root.val){
            up = Math.max(up, left.max_up + 1);
        }
        if(root.right != null && root.right.val + 1 == root.val){
            down = Math.max(down, right.max_down + 1);
        }
        if(root.right != null && root.right.val - 1 == root.val){
            up = Math.max(up, right.max_up + 1);
        }
        int len = down + up + 1;
        len = Math.max(len, Math.max(left.max_length, right.max_length));
        return new TreeInfo(len, down, up);
    }
}