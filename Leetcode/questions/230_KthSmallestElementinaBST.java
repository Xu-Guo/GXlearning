/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class 230_KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            count++;
            if(count == k){
                return node.val;
            }
            if(node.right!=null){
                cur = node.right;
            }
        }
        return -1;
    }
}


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
    public int kthSmallest(TreeNode root, int k) {
        int left = countNodes(root.left);
        if(left >= k){//左子树节点数多余K，说明result在root左边
            return kthSmallest(root.left, k);
        }else if(left < k-1){//左子树节点数+1个root不够k个，result在右边
            return kthSmallest(root.right, k - left - 1);//左边+root一共有count+1个，右边找第k-(count + 1)个
        }else{//left=k-1，root is result
            return root.val;
        }
    }
    
    private int countNodes(TreeNode root){
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}