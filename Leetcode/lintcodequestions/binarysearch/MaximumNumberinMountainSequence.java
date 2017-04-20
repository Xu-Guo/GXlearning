public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums[0] > nums[1]){
            return nums[0];
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]){
            return nums[nums.length -1];
        }
        
        int l = 1;
        int r = nums.length -2;
        while(l+1 < r){
            int mid = l + (r - l)/2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return nums[mid];
            }else if(nums[mid] < nums[mid - 1]){
                r = mid;
            }else{
                l = mid;
            }
        }
        
        return nums[l];
        // if(nums[r] > nums[l]){
        //     return nums[r];
        // }else{
        //     return nums[l];
        // }
    }
}