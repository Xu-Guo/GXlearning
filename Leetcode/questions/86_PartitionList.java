//creat 2 new listNode head;
//iterate through the list
//    if node.val < x,  attach to head1,
//    else attach to head2
//cut off the tail on head2.
//return dummy1.next          
public class 86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode head2 = dummy2;
        while(head!=null){
            if(head.val < x){
                head1.next =head;
                head1=head1.next;
            }else{
                head2.next = head;
                head2=head2.next;
            }
            head = head.next;
        }
        head2.next = null;
        head1.next = dummy2.next;
        return dummy1.next;
    }
}