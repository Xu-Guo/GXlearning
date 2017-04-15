/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
         Map<RandomListNode,RandomListNode> map = new HashMap<>();
         RandomListNode dummy = new RandomListNode(0);
         dummy.next = head;
         head = dummy;
         //copy node
         while(head!=null){
             if(!map.containsKey(head)){
                 map.put(head, new RandomListNode(head.label));
             }
             head = head.next;
         }
         //copy next and random pointer
         for(RandomListNode ori : map.keySet()){
             map.get(ori).next = map.get(ori.next);
             map.get(ori).random = map.get(ori.random);
         }
         return map.get(dummy.next);
         
    }
}