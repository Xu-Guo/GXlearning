//1.Find the m-1th node, then reverse
public class 92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;// pointer to the pre-node of the reverse
        for(int i=0; i<m-1; i++ ){
            pre = pre.next;
        }
        //reverse need pre, start, next pointer, loop n-m time
        ListNode start = pre.next;
        ListNode next = start.next;
        
        for(int i=0; i<n-m; i++){
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = start.next;
        }
        
        return dummy.next;
    }
}