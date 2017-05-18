public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum > target){
                r--;
            } else {
                count += r - l;
                l++;
            }
        }
        return count;
    }
}