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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 ||preorder.length != inorder.length){
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++ ){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer, Integer> map){
        if(ps > pe){
            return null;
        }
        if(ps == pe){
            return new TreeNode(preorder[ps]);
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int ri = map.get(preorder[ps]);
        root.left = buildTreeHelper(preorder, inorder, ps + 1, ps + ri - is, is, ri - 1, map);
        root.right = buildTreeHelper(preorder, inorder, ps + ri - is + 1, pe, ri + 1, ie, map);
        return root;
    }
}