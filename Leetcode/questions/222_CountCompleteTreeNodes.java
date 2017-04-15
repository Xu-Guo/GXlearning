public class 222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int count = 0;
        if(root == null){
            return 0;
        }
        int lh = 0;
        int rh = 0;
        TreeNode node = root;
        while(node != null){
            lh++;
            node = node.left;
        }
        node = root;
        while(node != null){
            rh++;
            node = node.right;
        }
        if(lh == rh){
            return (1<<lh) - 1;
        }else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
        
    }
}