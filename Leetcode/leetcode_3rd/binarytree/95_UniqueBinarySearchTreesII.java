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
1. if n == 0, return empty list
2. divide and conquer
for each num i in 1~n, i can be used as root node, 
-Its leftsubtrees should be formed with the numbers from 1 ~ (i - 1);
-Its rightSubtrees  should be formed with the numbers from (i + 1) ~ n
-subtrees can be generated by calling the function recursively
-at last we take each possible subtrees from left and right and form the new tree with the root i and and to list.
*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        
        for (int i =start; i <= end; i++){
            List<TreeNode> leftSubtrees = helper(start, i - 1);
            List<TreeNode> rightSubtrees = helper(i + 1, end);
            
            for(TreeNode left : leftSubtrees){
                for(TreeNode right : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}