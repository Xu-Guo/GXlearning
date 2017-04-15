public class 105_ConstructBinaryTreefromPreorderandInorderTraversal{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null || preorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        //store position of all nodes in inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer, Integer> map){
        if(ps > preorder.length - 1 || ps>pe || is>ie){
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int rootIndex = map.get(preorder[ps]);
        root.left = buildTreeHelper(preorder, inorder, ps+1, ps+1+rootIndex-is-1, is, rootIndex-1, map);
        root.right = buildTreeHelper(preorder, inorder, ps+1+rootIndex-is+1-1, pe, rootIndex+1, ie, map);
        return root;
    }
    
}