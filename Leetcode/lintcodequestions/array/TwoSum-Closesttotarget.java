public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // Write your code here
        int bestsum = nums[0] + nums[1];
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                return 0;
            }
            if(Math.abs(sum - target) < Math.abs(bestsum - target)){
                bestsum = sum;
            }
            if(sum > target){
                r--;
            }else {
                l++;
            }
        }
        return Math.abs(bestsum - target);
    }
}