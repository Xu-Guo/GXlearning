/*
*/
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        dp[0] = 1;
        return helper(nums, target, dp);
    }
    
    private int helper(int[] nums, int target, int[] dp){
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        //对于数组里每个小于target的数x,
        //dp[target] += dp[i-x]
        for (int n : nums) {
            if (target >= n) {
                res += helper(nums, target - n, dp);
            }
        }
        dp[target] = res;
        return res;
    }
}