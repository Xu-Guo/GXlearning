public class 215_KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }


    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            q.offer(nums[i]);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.peek(); 
    }

    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length-1;
        
        while(l < r){
            int left = l;
            int right = r;
            int p = nums[left];
            while(left < right){
                while(left < right && nums[right] <= p){//右边找大的
                    right--;
                }
                nums[left] = nums[right];
                while(left < right && nums[left] >= p){//左边找小的
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = p;
            if(left == k-1){
                return nums[k-1];
            }else if(left > k-1){
                r = left - 1;
            }else{
                l = left + 1;
            }
        }
        return nums[k-1];
    }


}