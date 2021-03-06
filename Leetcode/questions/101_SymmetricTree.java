//use helper function check left and right subtree
public class 101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right){
        if(left==null || right==null){
            return left == right;
        }
        if(left.val!=right.val){
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

//non recursive
    public boolean isSymmetricNonRecursive1(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while(q.size()>1){
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return left == right;
            }
            if(left.val != right.val){
                return false;
            }
            q.offer(left.left);
            q.offer(right.right);
            q.offer(left.right);
            q.offer(right.left);
        }
        return true;
    }
}