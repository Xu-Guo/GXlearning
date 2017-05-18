public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if(nums.length == 2){
            return new int[]{1,2};
        }
        int[] res = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int sum = nums[l] + nums[r];
            if(sum == target){
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if(sum > target){
                r--;
            } else {
                l++;
            }
        }
        return res;
    }
}