/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        int sum = 0;
        while(l1 != null || l2 != null){
            sum += carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
            sum = 0;
        }
        if (carry == 1){
            head.next = new ListNode(1);
        }
        return dummy.next;
    }
}