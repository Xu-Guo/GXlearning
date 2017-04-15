//must use  in-order traversal, BST's inorder result must be a sorted 
public class 98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre!=null && cur.val <= pre.val){
                return false;
            }
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}