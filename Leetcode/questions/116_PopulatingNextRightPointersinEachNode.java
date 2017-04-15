public class 116_PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeLinkNode head = new TreeLinkNode(0);
            for(int i=0; i<size; i++){
                TreeLinkNode cur = q.poll();
                head.next = cur;
                head = head.next;
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
    }
}