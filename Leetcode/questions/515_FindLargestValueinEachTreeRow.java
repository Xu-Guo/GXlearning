// simple BFS   O(v+e)
public class 515_FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int max = q.peek().val;
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(cur.val > max){
                    max = cur.val;
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            res.add(max);
        }
        return res;
    }
}