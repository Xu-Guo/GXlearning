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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode pre = null;
        TreeNode cur = root;
        
        Stack<TreeNode> s = new Stack<>();
        while(!s.isEmpty() || cur != null){
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            //example：
            //1  2  6  4  5  3
            //      p  c  p2 c2
            if(pre != null && cur.val <= pre.val){//当前节点值<=pre节点值
                if(first == null){//第一次找到不合法的节点，pre是错节点
                    first = pre;
                }
                second = cur;//第二个错误节点是cur，之后还会更新cur
            }
            pre = cur;
            cur = cur.right;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}