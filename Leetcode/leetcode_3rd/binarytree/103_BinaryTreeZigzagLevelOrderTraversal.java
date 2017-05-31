/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
Typical level order traversal, dont forget inc the level!!
*/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null){
            return res;    
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(level % 2 == 0){
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }
}