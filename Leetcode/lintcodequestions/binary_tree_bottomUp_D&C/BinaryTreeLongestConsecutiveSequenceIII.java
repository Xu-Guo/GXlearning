/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
class TreeInfo{
    public int max_length;
    public int max_down;
    public int max_up;
    public TreeInfo(int len, int down, int up){
        max_length = len;
        max_down = down;
        max_up = up;
    }
}
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */

    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).max_length;
    }
    
    private TreeInfo helper(MultiTreeNode root){
        if(root == null){
            return new TreeInfo(0, 0, 0);
        }
        int down = 0;
        int up = 0;
        int max_len = 1;
        List<MultiTreeNode> children = root.children;
        if(children != null && children.size() != 0){
            for(MultiTreeNode node : children){
                TreeInfo nodeInfo = helper(node);
                if(node.val + 1 == root.val){
                    down = Math.max(down, nodeInfo.max_down + 1);
                }
                if(node.val - 1 == root.val){
                    up = Math.max(up, nodeInfo.max_up + 1);
                }
                max_len = Math.max(max_len, nodeInfo.max_length);
            }
            max_len = Math.max(max_len, down + up + 1);
        }
        return new TreeInfo(max_len, down, up);
    }
}