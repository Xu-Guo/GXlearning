public class 111_MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.left == null && cur.right == null){
                    return level;
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
        return level;
    }
}