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
    public int rob(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }
    
    private int robHelper(TreeNode root, Map<TreeNode, Integer> map){
        if (root == null){
            return 0;
        }
        if (map.containsKey(root)){
            return map.get(root);
        }
        //calculate the val if we rob root
        int val = root.val;
        
        if (root.left != null){
            val += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }
        if (root.right != null){
            val += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }
        //calculate the max we can get
        int max = Math.max(val, robHelper(root.left, map) + robHelper(root.right, map));
        
        map.put(root, max);
        
        return max;
    }
}