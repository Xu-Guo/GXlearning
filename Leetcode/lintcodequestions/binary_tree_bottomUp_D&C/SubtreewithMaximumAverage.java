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
     * @return the root of the maximum average of subtree
     */
    TreeNode maxNode = null;
    Integer[] result = null; 
    
    
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        helper(root);
        return maxNode;
    }
    
    private Integer[] helper(TreeNode root){
        if(root == null){
            return new Integer[]{0, 0};
        }
        Integer[] leftInfo = helper(root.left);
        Integer[] rightInfo = helper(root.right);
        Integer sum = root.val + leftInfo[0] + rightInfo[0];
        Integer size = 1 + leftInfo[1] + rightInfo[1];
        
        
        if(result == null || result[0] * size < sum * result[1]){
            if(result == null){
                result = new Integer[2];
            }
            result[0] = new Integer(sum);
            result[1] = new Integer(size);
            maxNode = root;
        }
        Integer[] ret = new Integer[2];
        ret[0] = sum;
        ret[1] = size;
        return ret;
    }
}