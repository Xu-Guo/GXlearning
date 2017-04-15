public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, map);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> map){
        if(ps < 0 || ps > pe || is > ie){
            return null;
        }
        int rootIndex = map.get(postorder[pe]);
        int leftTreeSize = rootIndex - is - 1;
        TreeNode root = new TreeNode(postorder[pe]);
        root.left = buildTreeHelper(inorder, postorder, is, is+leftTreeSize, ps, ps+leftTreeSize, map);
        root.right = buildTreeHelper(inorder, postorder, is+leftTreeSize+2, ie, ps+leftTreeSize+1, pe-1, map);
        return root;
    }
}