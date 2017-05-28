public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minSum);//拿到一个新的sum后，先更新max，再更新minSum，否则错
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}