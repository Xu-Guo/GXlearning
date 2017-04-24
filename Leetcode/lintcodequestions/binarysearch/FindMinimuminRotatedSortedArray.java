public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        int target = nums[r];
        if(nums[0] < nums[r]){
            return nums[0];
        }
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(nums[l] <= target){
            return nums[l];
        }else{
            return nums[r];
        }
        
    }
}