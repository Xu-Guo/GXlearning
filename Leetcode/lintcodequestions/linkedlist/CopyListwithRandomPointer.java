/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;
        while(head != null){
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }
        
        head = dummy.next;
        while(head != null){
            if(head.random != null){
                if(!map.containsKey(head.random)){
                    map.put(head.random, new RandomListNode(head.label));
                }
                map.get(head).random = map.get(head.random);
            }
            map.get(head).next = map.get(head.next);
            head = head.next;
        }
        return map.get(dummy.next);
    }
}