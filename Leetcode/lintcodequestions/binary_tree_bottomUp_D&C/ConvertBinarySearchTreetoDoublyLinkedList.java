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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if(root == null){
            return null;
        }
        
        DoublyListNode newRoot = new DoublyListNode(root.val);
        
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode right = bstToDoublyList(root.right);
        
        newRoot.prev = left;
        newRoot.next = right;
        
        if(left != null){
            while(left.next != null){
                left = left.next;
            }
            left.next = newRoot;
        }
        
        if(right != null){
            while(right.prev != null){
                right = right.prev;
            }
            right.prev = newRoot;
        }
        
        while(newRoot.prev != null){
            newRoot = newRoot.prev;
        }
        return newRoot;
    }
    
    
}
