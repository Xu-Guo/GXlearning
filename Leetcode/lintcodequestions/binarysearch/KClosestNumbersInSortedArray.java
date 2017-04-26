public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] nums, int target, int k) {
        // Write your code here
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        
        int index = findFirstBE(nums, target);
        
        int left = index - 1;
        int right = index;
        
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            if (left < 0){
                result[i] = nums[right++];
            } else if(right > nums.length - 1){
                result[i] = nums[left--];
            } else {
                if (target - nums[left] <= nums[right] - target ){
                    result[i] = nums[left--];
                } else {
                    result[i] = nums[right++];
                }
            }
        }
        return result;
    }
    /*find first num that >= target, if all nums in the array less than target return nums.length
    if all nums >= target return first one
    */
    private int findFirstBE(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] >= target){
            return start;
        }
        if(nums[end] >= target){
            return end;
        }
        return nums.length;
    }
}