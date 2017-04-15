/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private String nul = "NULL";
    private String sp = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return nul;
        }
        
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            sb.append(cur.val).append(sp);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(nul)){
            return null;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        for(String node : data.split(sp)){
            q.offer(new TreeNode(Integer.parseInt(node)));
        }
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<TreeNode> q){
        if(q.isEmpty()){
            return null;
        }
        //get root
        TreeNode root = q.poll();
        //get left part
        Queue<TreeNode> lq = new LinkedList<>();
        while(!q.isEmpty() && (q.peek().val < root.val)){
            lq.offer(q.poll());
        }
        //build left tree
        root.left = buildTree(lq);
        //build right tree
        root.right = buildTree(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));