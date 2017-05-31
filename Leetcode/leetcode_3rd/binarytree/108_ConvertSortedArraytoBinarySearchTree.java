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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return buildTreeHelper(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        if (start == end){
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTreeHelper(nums, start, mid - 1);
        root.right = buildTreeHelper(nums, mid + 1, end);
        return root;
    }
}