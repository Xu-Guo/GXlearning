public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
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
            if(sum == target){
                count++;
                l++;
                r--;
                while( l < r && nums[l] == nums[l - 1]){
                    l++;
                }
                while( l < r && nums[r] == nums[r + 1]){
                    r--;
                }
            } else if (sum < target){
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}