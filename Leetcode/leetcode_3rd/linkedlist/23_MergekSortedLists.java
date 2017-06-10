/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int start, int end){
        if (start > end){
            return null;
        }
        
        if (start == end){
            return lists[start];
        }
        
        int mid = start + (end - start) / 2;
        ListNode left = partition(lists, start, mid);
        ListNode right = partition(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null){
            head.next = l1;
        }
        if (l2 != null){
            head.next = l2;
        }
        return dummy.next;
    }
}