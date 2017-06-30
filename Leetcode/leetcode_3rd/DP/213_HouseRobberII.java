public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        
        int robfirst = helper(nums, 0, nums.length - 2);
        int notrobfirst = helper(nums, 1, nums.length - 1);
        
        return Math.max(robfirst, notrobfirst);
    }
    
    private int helper(int[] nums, int start, int end){
        if (start == end){
            return nums[start];
        }
        if (start + 1 == end){
            return Math.max(nums[start], nums[end]);
        }
        int a = 0;
        int b = 0;
        for (int i = start; i <= end; i++){
            if (i % 2 == 0){
                a += nums[i];
                a = Math.max(a, b);
            } else {
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a, b);
    }
}