/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        int depth = getDepth(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while (!q.isEmpty()){
            level++;
            if (level == depth){
                return q.peek().val;
            }
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
    
    private int getDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}