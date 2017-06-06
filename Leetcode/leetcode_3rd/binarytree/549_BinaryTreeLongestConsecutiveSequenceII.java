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
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int[] longestPath(TreeNode root){
    	if (root == null){
    		return new int[] {0,0};
    	}
    	int inc = 1;
    	int dec = 1;
    	int[] left = longestPath(root.left);
    	int[] right = longestPath(root.right);
    	if (root.left != null){
    		if (root.left.val == root.val + 1){
    			inc = left[0] + 1;
    		} else if (root.left.val == root.val - 1){
    			dec = left[1] + 1;
    		}
    	}
    	if (root.right != null){
    		if (root.right.val == root.val + 1){
    			inc = Math.max(inc, right[0] + 1);
    		} else if (root.right.val == root.val - 1){
    			dec = Math.max(dec, right[1] + 1);
    		}
    	}
    	max = Math.max(max, inc + dec - 1);
    	return new int[] {inc, dec};
    }
}