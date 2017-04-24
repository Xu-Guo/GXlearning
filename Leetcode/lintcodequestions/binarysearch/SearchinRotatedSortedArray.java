public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int l = 0;
        int r = nums.length - 1;
        int last = nums[r];
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(target > last){
                if(nums[mid] < target && nums[mid] > last){
                    l = mid;
                }else {
                    r = mid;
                }
            } else {
                if(nums[mid] > target && nums[mid] < last){
                    r = mid;
                } else {
                    l = mid;
                }
            }
        }
        if(nums[l] == target){
            return l;
        }
        if(nums[r] == target){
            return r;
        }
        return -1;
    }
}