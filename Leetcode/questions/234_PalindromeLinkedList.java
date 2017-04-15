//use stack for reverse the second half
public class 234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null){//odd
            slow = slow.next; //make slow the head of the right half
        }
        Stack<ListNode> stack = new Stack<>();
        while(slow!=null){
            stack.push(slow);
            slow = slow.next;
        }
        fast = head;
        while(!stack.isEmpty()){
            if(fast.val != stack.pop().val){
                return false;
            }
            fast = fast.next;
        }
        return true;
    }
}

//use reverse function
public class Solution {
    public boolean isPalindrome1(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null){//odd
            slow = slow.next; //make slow the head of the right half
        }
        
        slow = reverse(slow);
        fast =head;
        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}