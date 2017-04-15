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
    public List<Integer> postorderTraversal(TreeNode root) {    
        if(root == null){
            return new ArrayList<Integer>();
        }
        
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode cur = s1.pop();
            s2.push(cur);
            if(cur.left!=null){
                s1.push(cur.left);
            }
            if(cur.right!=null){
                s1.push(cur.right);
            }
        }
        while(!s2.isEmpty()){
            result.add(s2.pop().val);
        }
        return result;
    }   
}