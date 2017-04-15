//cur is the last node of the duplicate
//  cur start from head.next
//  while cur!=null
//      skip duplicates and move cur to the lase node of duplicates
//          if head.next == cur -> head=head.next , no duplicates
//            else cur must be removed, head.next = cur.next
//  return dummy.next; 

public class 82_RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode cur = head.next;
        while(cur != null){
            while(cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }
            if(head.next == cur){
                head = head.next;
            }else{
                head.next = cur.next;
            }
            cur = head.next;
        }
        return dummy.next;
    }
}
