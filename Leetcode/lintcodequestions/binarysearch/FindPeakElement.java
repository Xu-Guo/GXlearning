class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int l = 1;
        int r = nums.length - 2;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            } else if (nums[mid] < nums[mid + 1]){
                l = mid;
            } else {
                r = mid;
            }
        }
        if(nums[l] > nums[r]){
            return l;
        }else {
            return r;
        }
    }
}
