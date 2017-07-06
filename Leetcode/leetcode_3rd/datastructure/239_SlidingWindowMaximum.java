public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < k - 1; i++){
            inQueue(dq, nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; i++){
            inQueue(dq, nums[i]);
            list.add(dq.peekFirst());
            outQueue(dq, nums[i - k + 1]);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void inQueue(Deque<Integer> dq, int num){
        //queue maintain decending order for maximum, ascending order for minimum
        while (!dq.isEmpty() && dq.peekLast() < num){
            dq.pollLast();
        }
        dq.offer(num);
    }
    
    private void outQueue(Deque<Integer> dq, int num){
        if (dq.peekFirst() == num){
            dq.pollFirst();
        }
    }
}