/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//使用2个队列，其中一个用来存放当前节点的列标，每次poll并且记录min，max，相同列标的节点值存入相应list中
public class 314_BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> colq = new LinkedList<>();
        
        q.offer(root);
        colq.offer(0);
        
        int mincol = 0;
        int maxcol = 0;
        
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            int col = colq.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(cur.val);
            
            if(cur.left!=null){
                q.offer(cur.left);
                colq.offer(col - 1);
                mincol = Math.min(mincol, col-1);
            }
            
            if(cur.right!=null){
                q.offer(cur.right);
                colq.offer(col + 1);
                maxcol = Math.max(maxcol, col+1);
            }
        }
        
        for(int i=mincol; i<=maxcol; i++){
            res.add(map.get(i));
        }
        return res;
        
    }
}