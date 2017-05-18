/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if(node == null){
            node = new ListNode(x);
            node.next = node;
            return node;
        }
        ListNode prev = null;
        ListNode cur = node;
        //go through the list from node
        do {
            prev = cur;
            cur = cur.next;
            //find the position
            if(x >= prev.val && x <= cur.val){
                break;
            }
            
            //cur at the min node, prev at max node 
            if(cur.val < prev.val && (x < cur.val || x > prev.val)){
                break;
            }
        } while (cur != node);
        
        ListNode newNode = new ListNode(x);
        prev.next = newNode;
        newNode.next = cur;
        return newNode;
    }
}