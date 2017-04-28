/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

/*pre-order traversal*/
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    String spliter = ",";
    String NULL = "#";
    
    
    public String serialize(TreeNode root) {
        // write your code here
        //build string with pre-order traversal
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(spliter);
            return;
        }
        
        sb.append(root.val).append(spliter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        Queue<String> list = new LinkedList<>();
        for(String node : data.split(spliter)){
            list.offer(node);
        }
        return buildTree(list);
    }
    
    private TreeNode buildTree(Queue<String> list){
        String val = list.poll();
        if(val.equals(NULL)){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(list);
        root.right = buildTree(list);
        
        return root;
    }
}
