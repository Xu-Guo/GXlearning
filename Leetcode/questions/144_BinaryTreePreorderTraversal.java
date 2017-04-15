public class 144_BinaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return res;
        }
        helper(root);
        return res;
    }
    
    private void helper(TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        helper(root.left);
        helper(root.right);
    }
    
}


public class 144_BinaryTreePreorderTraversal1{
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left); 
            }
        }
        return res;
    }
}