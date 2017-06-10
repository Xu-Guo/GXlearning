/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (c1 != null && c2 != null){
            if (c1.val <= c2.val){
                head.next = c1;
                c1 = c1.next;
            } else {
                head.next = c2;
                c2 = c2.next;
            }
            head = head.next;
        }
        if (c1 != null){
            head.next = c1;
        }
        if (c2 != null){
            head.next = c2;
        }
        return dummy.next;
    }
}