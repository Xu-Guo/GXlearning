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
-build String using pre-order traversal,root -> build left -> build right,use StringBuilder to append new node val in each call
-build Tree using the same idea, check if the root value is null, 
*/
public class Codec {
    private String spliter = ",";
    private String nul = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(nul).append(spliter);
            return;
        }
        sb.append(root.val).append(spliter);
        buildString(root.left, sb);
        buildString(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(LinkedList<String> data){
        String val = data.removeFirst();
        if (val.equals(nul)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));