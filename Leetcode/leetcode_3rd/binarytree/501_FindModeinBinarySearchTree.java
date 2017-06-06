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
    public int[] findMode(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        int max = 1;
        int count = 1;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev != null){
                if (cur.val == prev.val){
                    count++;
                } else {
                    count = 1;
                }
            } 
            if (count > max){
                max = count;
                list.clear();
                list.add(cur.val);
            } else if (count == max){
                list.add(cur.val);
            }
            
            prev = cur;
            cur = cur.right;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}