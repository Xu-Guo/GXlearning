/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
1. count the number of node in left subtree
-if count >= k, target is in the left subtree
    -recurse call
-else if k > count + 1, (left nodes + root), target is in the right subtree
    -recurse call  
-else the root is the kth node
*/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (count >= k){
            return kthSmallest(root.left, k);
        }
        if (k > count + 1 ){
            return kthSmallest(root.right, k - 1 - count);
        } 
        return root.val;
    }
    
    private int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}