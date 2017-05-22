public class Solution {
    Queue<Integer> q;
    int size;
    public Solution(int k) {
        // initialize your data structure here.
        q = new PriorityQueue<Integer>(k);
        size = k;
    }

    public void add(int num) {
        // Write your code here
        q.offer(num);
        if(q.size() > size){
            q.poll();
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for(Integer i : q){
            list.add(i);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }
}