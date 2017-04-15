//if head.next != null, 
//  if head.next.val == head.val, head.next == head.next.next
//  else head = head.next;

public class 83_RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null){
            if(head.next.val == head.val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}