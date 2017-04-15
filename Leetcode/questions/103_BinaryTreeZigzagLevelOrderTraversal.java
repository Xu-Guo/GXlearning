//track the level, if level % 2 != 0, add new TreeNode at end of list, else add TreeNode at head
public class Solution {
    public List<List<Integer>> 103_BinaryTreeZigzagLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode cur = q.poll();
                if(level % 2 != 0){
                    list.add(cur.val);
                }else{
                    list.add(0, cur.val);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}