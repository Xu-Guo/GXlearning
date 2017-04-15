//flatten left and flatten right, set root.left = null, connect new left to root.right, conncet right to very right on the new left
public class 114_FlattenBinaryTreetoLinkedList {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode cur = root;
        while(cur.right!=null){
            cur = cur.right;
        }
        cur.right = right;
    }
}