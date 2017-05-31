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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> map){
        if(ps > pe){
            return null;
        }
        if(ps == pe){
            return new TreeNode(postorder[ps]);
        }
            
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = map.get(postorder[pe]);
        root.left = buildTreeHelper(inorder, postorder, is, ri - 1, ps, ps + ri - is - 1, map);
        root.right = buildTreeHelper(inorder, postorder, ri + 1, ie, ps + ri - is, pe - 1, map);
        return root;
    }
}